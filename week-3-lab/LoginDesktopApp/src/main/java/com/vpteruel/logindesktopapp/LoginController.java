package com.vpteruel.logindesktopapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.sql.*;

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
        System.out.println("Login attempt: Username = " + username.getText() + ", Password = " + password.getText());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/my_database",
                    "root",
                    "123");

            String sql = "select id from users where username=? and password=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, username.getText());
            pstmt.setString(2, password.getText());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}