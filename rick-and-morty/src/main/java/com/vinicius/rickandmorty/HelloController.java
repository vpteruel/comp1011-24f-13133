package com.vinicius.rickandmorty;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HelloController {

    @FXML
    private TableView<Character> charactersTable;

    @FXML
    private TableColumn<Character, Integer> idColumn;

    @FXML
    private TableColumn<Character, String> nameColumn;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        ApiUtility apiUtility = new ApiUtility();

        List<Character> characters = new ArrayList<>();

        characters = apiUtility.getAllCharacters("https://rickandmortyapi.com/api/character");

        charactersTable.getItems().addAll(characters);
    }
}