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
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    public void initialize() {
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Login");
            alert.setHeaderText(null);
            alert.setContentText("Username or Password cannot be empty!");
            alert.showAndWait();
            return;
        }

        UserEntity user = UserService.getUserByLogin(username, password);

        if (user != null && user.getId() > 0) {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("welcome.fxml"));
                Parent root = fxmlLoader.load();
                Scene welcomeScene = new Scene(root, 800, 600);
                Stage currentStage = (Stage) loginButton.getScene().getWindow();
                WelcomeController controller = fxmlLoader.getController();

                controller.initialize(username);
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

    @FXML
    private void handleSignup() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("signup.fxml"));
            Parent root = fxmlLoader.load();
            Scene signupScene = new Scene(root, 800, 600);
            Stage currentStage = (Stage) loginButton.getScene().getWindow();
            currentStage.setScene(signupScene);
            currentStage.setTitle("Sign Up - Hotel Booking System");
        } catch (IOException e) {
            System.err.println("Failed to load the welcome screen: " + e.getMessage());
        }
    }
}
