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
    private Label emailLabel;

    @FXML
    public void initialize(String email) {
        emailLabel.setText(email);
    }

    @FXML
    private void handleRoomManagement() {
        System.out.println("Navigating to Room Management...");
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
        // Add navigation logic or scene switch here
    }

    @FXML
    private void handleRoomAvailability() {
        System.out.println("Navigating to Room Availability and Booking...");
        // Add navigation logic or scene switch here
    }

    @FXML
    private void handleLogout() {
        System.out.println("Logging out...");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("login.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) emailLabel.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
            stage.setTitle("Login - Hotel Booking System");
        } catch (IOException e) {
            System.err.println("Error loading login screen: " + e.getMessage());
        }
    }
}