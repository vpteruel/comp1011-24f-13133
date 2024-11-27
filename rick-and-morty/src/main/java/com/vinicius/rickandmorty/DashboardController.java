package com.vinicius.rickandmorty;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DashboardController {

    @FXML
    public Label quantityLabel;

    @FXML
    public PieChart statusPieChart;

    @FXML
    public PieChart speciesPieChart;

    @FXML
    public PieChart genderPieChart;

    @FXML
    public void initialize() {

        ApiClient apiClient = new ApiClient();

        List<Character> characters = apiClient.getAllCharacters();

        quantityLabel.setText(String.valueOf(characters.size()));

        loadStatusPieChart(characters);
        loadSpeciesPieChart(characters);
        loadGenderPieChart(characters);
    }

    private void loadStatusPieChart(List<Character> characters) {
        Set<String> distinctStatus = characters.stream()
                .map(Character::getStatus)
                .filter(status -> status != null && !status.isEmpty())
                .collect(Collectors.toSet());

        for (String status : distinctStatus) {
            long data = characters.stream()
                    .filter(character -> status.equalsIgnoreCase(character.getStatus()))
                    .count();

            PieChart.Data slice = new PieChart.Data(status, data);
            slice.setName(status + " - " + (slice.getPieValue() / 10) + "%");

            statusPieChart.getData().add(slice);
        }
    }

    private void loadSpeciesPieChart(List<Character> characters) {
        Set<String> distinctSpecies = characters.stream()
                .map(Character::getSpecies)
                .filter(species -> species != null && !species.isEmpty())
                .collect(Collectors.toSet());

        for (String species : distinctSpecies) {
            long data = characters.stream()
                    .filter(character -> species.equalsIgnoreCase(character.getSpecies()))
                    .count();

            PieChart.Data slice = new PieChart.Data(species, data);
            slice.setName(species + " - " + (slice.getPieValue() / 10) + "%");

            speciesPieChart.getData().add(slice);
        }
    }

    private void loadGenderPieChart(List<Character> characters) {
        Set<String> distinctGenders = characters.stream()
                .map(Character::getGender)
                .filter(gender -> gender != null && !gender.isEmpty())
                .collect(Collectors.toSet());

        for (String gender : distinctGenders) {
            long data = characters.stream()
                    .filter(character -> gender.equalsIgnoreCase(character.getGender()))
                    .count();

            PieChart.Data slice = new PieChart.Data(gender, data);
            slice.setName(gender + " - " + (slice.getPieValue() / 10) + "%");

            genderPieChart.getData().add(slice);
        }
    }
}
