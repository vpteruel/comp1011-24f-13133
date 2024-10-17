package com.vinicius.hotelbookingsystem.common;

import com.vinicius.hotelbookingsystem.MainApp;
import com.vinicius.hotelbookingsystem.users.UserEntity;
import com.vinicius.hotelbookingsystem.users.UserPreferences;
import com.vinicius.hotelbookingsystem.users.UserService;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private ImageView loadingGif;

    @FXML
    public void initialize() {

        String username = UserPreferences.getUsername();

        if (username != null) {
            usernameField.setText(username);
            passwordField.requestFocus();
        } else {
            usernameField.requestFocus();
        }
    }

    @FXML
    private void handleLogin() {

        // show the loading GIF before starting the login process
        loadingGif.setVisible(true);

        // create a new Task for the login process
        Task<Void> loginTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                String username = usernameField.getText();
                String password = passwordField.getText();

                if (username.isEmpty() || password.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Login");
                    alert.setHeaderText(null);
                    alert.setContentText("Username or Password cannot be empty!");
                    alert.showAndWait();
                    return null;
                }

                UserEntity user = UserService.getUserByLogin(username, password);

                // once the background process is done, update the UI on the JavaFX Application Thread
                Platform.runLater(() -> {

                    // hide the loading GIF after the login process
                    loadingGif.setVisible(false);

                    if (user != null && user.getId() > 0) {

                        try {
                            UserPreferences.setUsername(username);

                            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("welcome.fxml"));
                            Parent root = fxmlLoader.load();
                            Scene scene = new Scene(root, 800, 600);
                            Stage currentStage = (Stage) loginButton.getScene().getWindow();
                            currentStage.setScene(scene);
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
                });
                return null;
            }
        };

        // run the task in a background thread
        new Thread(loginTask).start();
    }

    @FXML
    private void handleSignup() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("signup.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 800, 600);
            Stage currentStage = (Stage) loginButton.getScene().getWindow();
            currentStage.setScene(scene);
            currentStage.setTitle("Sign Up - Hotel Booking System");
        } catch (IOException e) {
            System.err.println("Failed to load the welcome screen: " + e.getMessage());
        }
    }
}
