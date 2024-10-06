package com.vinicius.hotelbookingsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {

    @FXML
    private Button roomManagementButton;

    @FXML
    private Button bookingManagementButton;

    @FXML
    private Button roomAvailabilityButton;

    @FXML
    private Label usernameLabel;

    @FXML
    public void initialize(String username) {

        usernameLabel.setText(username);
    }

    @FXML
    private void handleRoomManagement() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("room_management.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage currentStage = (Stage) roomManagementButton.getScene().getWindow(); // Get current stage
            currentStage.setScene(scene);
            currentStage.setTitle("Room Management - Hotel Booking System");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void handleBookingManagement() {

        System.out.println("Navigating to Booking Management...");

        comingSoonAlert();
    }

    @FXML
    private void handleRoomAvailability() {

        System.out.println("Navigating to Room Availability and Booking...");

        comingSoonAlert();
    }

    @FXML
    private void handleLogout() {

        System.out.println("Logging out...");

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("login.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) usernameLabel.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
            stage.setTitle("Login - Hotel Booking System");
        } catch (IOException e) {
            System.err.println("Error loading login screen: " + e.getMessage());
        }
    }

    private void comingSoonAlert() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Welcome");
        alert.setHeaderText(null);
        alert.setContentText("Coming Soon!");
        alert.showAndWait();
    }
}
