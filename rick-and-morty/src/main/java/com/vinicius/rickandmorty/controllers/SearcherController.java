package com.vinicius.rickandmorty.controllers;

import com.vinicius.rickandmorty.enums.View;
import com.vinicius.rickandmorty.models.Character;
import com.vinicius.rickandmorty.utils.ApiClient;
import com.vinicius.rickandmorty.utils.LoaderUtil;
import com.vinicius.rickandmorty.utils.UserPreferences;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearcherController {
    private Popup popup;
    private ListView<String> suggestionList;

    @FXML
    private Pane contentPane;

    @FXML
    private TextField autocompleteTextField;

    @FXML
    public void initialize() {
        loadCharacter("");
        loadSuggestions();
    }

    private void loadSuggestions() {
        ApiClient apiClient = new ApiClient();

        List<Character> characters = apiClient.getAllCharacters();

        List<String> allNames = characters.stream()
                .map(com.vinicius.rickandmorty.models.Character::getName)  // Extract the name from each character
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        ObservableList<String> suggestions = FXCollections.observableArrayList(allNames);

        // Initialize ListView for suggestions
        suggestionList = new ListView<>();
        suggestionList.setMaxHeight(200); // Limit height of the suggestion box
        suggestionList.setPrefWidth(716);
        suggestionList.setItems(suggestions);

        // Initialize Popup
        popup = new Popup();
        popup.setAutoHide(true);
        popup.getContent().add(suggestionList);

        // Add listener for text input
        autocompleteTextField.textProperty().addListener((obs, oldText, newText) -> {
            if (newText.isEmpty()) {
                popup.hide();
            } else {
                ObservableList<String> filteredSuggestions = suggestions.filtered(item ->
                        item.toLowerCase().contains(newText.toLowerCase()));
                if (!filteredSuggestions.isEmpty()) {
                    suggestionList.setItems(filteredSuggestions);
                    if (!popup.isShowing()) {
                        popup.show(autocompleteTextField.getScene().getWindow(),
                                autocompleteTextField.localToScreen(0, autocompleteTextField.getHeight()).getX(),
                                autocompleteTextField.localToScreen(0, autocompleteTextField.getHeight()).getY());
                    }
                } else {
                    popup.hide();
                }
            }
        });

        // Handle mouse click selection from ListView
        suggestionList.setOnMouseClicked(event -> {
            String selected = suggestionList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                autocompleteTextField.setText(selected);
                popup.hide();
                loadCharacter(selected);
            }
        });

        // Handle key events for navigation and selection
        autocompleteTextField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.DOWN) {
                // Navigate down in the suggestion list
                if (!popup.isShowing() && !suggestionList.getItems().isEmpty()) {
                    popup.show(autocompleteTextField.getScene().getWindow(),
                            autocompleteTextField.localToScreen(0, autocompleteTextField.getHeight()).getX(),
                            autocompleteTextField.localToScreen(0, autocompleteTextField.getHeight()).getY());
                }
                suggestionList.requestFocus();
                suggestionList.getSelectionModel().selectNext();
            } else if (event.getCode() == KeyCode.UP) {
                // Navigate up in the suggestion list
                suggestionList.requestFocus();
                suggestionList.getSelectionModel().selectPrevious();
            } else if (event.getCode() == KeyCode.ENTER) {
                // Select the currently highlighted suggestion
                String selected = suggestionList.getSelectionModel().getSelectedItem();
                if (selected != null) {
                    autocompleteTextField.setText(selected);
                    popup.hide();
                    loadCharacter(selected);
                }
            } else if (event.getCode() == KeyCode.ESCAPE) {
                // Close the popup
                popup.hide();
            }
        });

        // Handle focus loss on ListView
        suggestionList.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String selected = suggestionList.getSelectionModel().getSelectedItem();
                if (selected != null) {
                    autocompleteTextField.setText(selected);
                    popup.hide();
                    loadCharacter(selected);
                }
            }
        });
    }

    private void loadCharacter(String name) {
        Character character = getCharacter(name);

        if (character != null) {
            FXMLLoader loader = LoaderUtil.loadContentView(contentPane, View.CHARACTER);
            CharacterController characterController = loader.getController();

            characterController.loadCharacter(character);
        } else {
            LoaderUtil.loadContentView(contentPane, View.SKELETON_LOADING);
        }
    }

    private Character getCharacter(String name) {
        UserPreferences userPreferences = new UserPreferences();
        Character character = new Character();

        if (!name.isEmpty()) {
            ApiClient apiClient = new ApiClient();
            Optional<Character> optionalCharacter = apiClient.getCharacterByName(name);
            if (optionalCharacter.isPresent()) {
                character = optionalCharacter.get();
                userPreferences.setCharacter(character);
            }
        } else {
            character = userPreferences.getCharacter();
        }
        return character;
    }
}
