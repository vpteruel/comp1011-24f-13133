package com.vinicius.hotelbookingsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    private String DEFAULT_EMAIL = "admin@hotelbookingsystem.com";
    private String DEFAULT_PASSWORD = "admin123";

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox rememberMeCheckBox;

    @FXML
    private Button loginButton;

    @FXML
    public void initialize() {
        emailField.setText(DEFAULT_EMAIL);
        passwordField.setText(DEFAULT_PASSWORD);
    }

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();
        boolean rememberMe = rememberMeCheckBox.isSelected();

        if (email.equals(DEFAULT_EMAIL)
            && password.equals(DEFAULT_PASSWORD)) {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("welcome.fxml"));
                Parent root = fxmlLoader.load();
                Scene welcomeScene = new Scene(root, 800, 600);
                Stage currentStage = (Stage) loginButton.getScene().getWindow();
                WelcomeController controller = fxmlLoader.getController();

                controller.initialize(email);
                currentStage.setScene(welcomeScene);
                currentStage.setTitle("Welcome - Hotel Booking System");
            } catch (IOException e) {
                System.err.println("Failed to load the welcome screen: " + e.getMessage());
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Login");
            alert.setHeaderText(null);
            alert.setContentText("Username or Password incorrect!");
            alert.showAndWait();
        }
    }
}
