package com.vinicius.rickandmorty.controllers;

import com.vinicius.rickandmorty.enums.View;
import com.vinicius.rickandmorty.models.Character;
import com.vinicius.rickandmorty.utils.LoaderUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class CharacterController {

    @FXML
    private Rectangle characterImage;

    @FXML
    private Label characterName;

    @FXML
    private Circle characterStatusIcon;

    @FXML
    private Label characterStatusSpecies;

    @FXML
    private Label characterOrigin;

    @FXML
    private Label characterLocation;

    @FXML
    private ListView<String> characterEpisodes;

    public void loadCharacter(Character character) {
        if (character == null) return;

        Image image = new Image(character.getImage());
        ObservableList<String> episodes = FXCollections.observableArrayList(character.getEpisode());

        characterImage.setFill(new ImagePattern(image));
        characterName.setText(character.getName());
        switch (character.getStatus()) {
            case "Alive": characterStatusIcon.setFill(Color.GREEN); break;
            case "Dead": characterStatusIcon.setFill(Color.RED); break;
            case "unknown": characterStatusIcon.setFill(Color.GRAY); break;
        }
        characterStatusSpecies.setText(character.getStatus() + " - " + character.getSpecies());
        characterOrigin.setText(character.getOrigin().getName());
        characterLocation.setText(character.getLocation().getName());
        characterEpisodes.setItems(episodes);

        characterEpisodes.setOnMouseClicked(this::handleMouseClick);
        characterEpisodes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println("Selected: " + newValue);
            }
        });
    }

    private void handleMouseClick(MouseEvent event) {
        String selectedEpisode = characterEpisodes.getSelectionModel().getSelectedItem();
        if (selectedEpisode != null && event.getClickCount() == 2) { // Double-click action
            FXMLLoader loader = LoaderUtil.loadView(View.EPISODE);
            EpisodeController controller = loader.getController();
            controller.loadEpisode(selectedEpisode);
        }
    }
}
