package com.vinicius.rickandmorty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CharacterController {

    private ApiClient apiClient;

    @FXML
    private TextField autocompleteTextField;

    private Popup popup;
    private ListView<String> suggestionList;

    @FXML
    private ImageView characterImage;

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
    public void initialize() {

        apiClient = new ApiClient();

        List<Character> characters = apiClient.getAllCharacters();

        List<String> allNames = characters.stream()
                .map(Character::getName)  // Extract the name from each character
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

        Optional<Character> optionalCharacter = apiClient.getByName(name);

        if (optionalCharacter.isPresent()) {
            Character character = optionalCharacter.get();
            characterImage.setImage(new Image(character.getImage()));
            characterName.setText(name);
            switch (character.getStatus()) {
                case "Alive": characterStatusIcon.setFill(Color.GREEN); break;
                case "Dead": characterStatusIcon.setFill(Color.RED); break;
                case "unknown": characterStatusIcon.setFill(Color.GRAY); break;
            }
            characterStatusSpecies.setText(character.getStatus() + " - " + character.getSpecies());
            characterOrigin.setText(character.getOrigin().getName());
            characterLocation.setText(character.getLocation().getName());
        }
    }
}
