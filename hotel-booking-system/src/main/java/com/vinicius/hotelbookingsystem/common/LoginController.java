package com.vinicius.hotelbookingsystem.common;

import com.vinicius.hotelbookingsystem.MainApp;
import com.vinicius.hotelbookingsystem.users.UserEntity;
import com.vinicius.hotelbookingsystem.users.UserService;
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
                Scene scene = new Scene(fxmlLoader.load(), 800, 600);
                Stage currentStage = (Stage) loginButton.getScene().getWindow();
                currentStage.setScene(scene);
                currentStage.setTitle("Welcome - Hotel Booking System");
                WelcomeController controller = fxmlLoader.getController();
                controller.initialize(username);
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
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage currentStage = (Stage) loginButton.getScene().getWindow();
            currentStage.setScene(scene);
            currentStage.setTitle("Sign Up - Hotel Booking System");
        } catch (IOException e) {
            System.err.println("Failed to load the welcome screen: " + e.getMessage());
        }
    }
}
