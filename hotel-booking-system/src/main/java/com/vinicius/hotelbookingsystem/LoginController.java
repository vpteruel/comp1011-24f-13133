package com.vinicius.hotelbookingsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

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
    }

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();
        boolean rememberMe = rememberMeCheckBox.isSelected();

        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Remember Me: " + rememberMe);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("welcome.fxml"));
            Parent root = fxmlLoader.load();
            Scene welcomeScene = new Scene(root, 800, 600);
            Stage currentStage = (Stage) loginButton.getScene().getWindow();
            WelcomeController controller = fxmlLoader.getController();

            currentStage.setScene(welcomeScene);
            currentStage.setTitle("Welcome - Hotel Booking System");
            controller.initialize(emailField.getText());
        } catch (IOException e) {
            System.err.println("Failed to load the welcome screen: " + e.getMessage());
        }
    }
}
