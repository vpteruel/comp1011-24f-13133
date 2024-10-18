package com.vinicius.question11;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UserFormController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField ageField;

    @FXML
    private Label messageLabel;

    @FXML
    public void handleSubmit() {
        String name = nameField.getText();
        String ageText = ageField.getText();
        messageLabel.setText("");

        try {
            int age = Integer.parseInt(ageText);
            if (age < 18) {
                messageLabel.setText("Warning: You must be at least 18 years old.");
            } else {
                messageLabel.setText("Welcome, " + name + "!");
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Please enter a valid age.");
        }
    }
}