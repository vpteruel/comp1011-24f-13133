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

public class SignupController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button signupButton;

    @FXML
    public void initialize() {
    }

    @FXML
    private void handleSignup() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Signup");
            alert.setHeaderText(null);
            alert.setContentText("Username or Password cannot be empty!");
            alert.showAndWait();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Signup");
            alert.setHeaderText(null);
            alert.setContentText("Passwords do not match!");
            alert.showAndWait();
            return;
        }

        try {
            UserEntity user = new UserEntity(username, password);

            boolean hasAdded = UserService.addUser(user);

            if (!hasAdded) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Signup");
                alert.setHeaderText(null);
                alert.setContentText("Username already exists!");
                alert.showAndWait();
                return;
            }

            usernameField.clear();
            passwordField.clear();
            confirmPasswordField.clear();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Signup");
            alert.setHeaderText(null);
            alert.setContentText("Username created successfully!");
            alert.showAndWait();

            handleLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLogin() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("login.fxml"));
            Parent root = fxmlLoader.load();
            Scene loginScene = new Scene(root, 800, 600);
            Stage currentStage = (Stage) signupButton.getScene().getWindow();
            currentStage.setScene(loginScene);
            currentStage.setTitle("Login - Hotel Booking System");
        } catch (IOException e) {
            System.err.println("Failed to load the welcome screen: " + e.getMessage());
        }
    }
}
