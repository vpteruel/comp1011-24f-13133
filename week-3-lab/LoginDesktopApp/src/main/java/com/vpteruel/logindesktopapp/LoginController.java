package com.vpteruel.logindesktopapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private Label wrongLogIn;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    public void initialize() {
        // Add initialization logic here if needed
        loginButton.setOnAction(event -> handleLogin());
    }

    private void handleLogin() {
        // Implement your login logic here
        System.out.println("Login attempt: Username = " + username.getText() + ", Password = " + password.getText());
    }
}