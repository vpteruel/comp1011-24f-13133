package com.vinicius.hotelbookingsystem.common;

import com.vinicius.hotelbookingsystem.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

        System.out.println("Navigating to Room Management...");

        try {
            loadScene("roomManagement.fxml", "Room Management - Hotel Booking System");
        } catch (IOException e) {
            System.err.println("Error loading room management screen: " + e.getMessage());
        }
    }

    @FXML
    private void handleBookingManagement() {

        System.out.println("Navigating to Booking Management...");

        try {
            loadScene("bookingManagement.fxml", "Booking Management - Hotel Booking System");
        } catch (IOException e) {
            System.err.println("Error loading booking management screen: " + e.getMessage());
        }
    }

    @FXML
    private void handleRoomAvailability() {

        System.out.println("Navigating to Room Availability and Booking...");

        try {
            loadScene("bookRoom.fxml", "Book Room - Hotel Booking System");
        } catch (IOException e) {
            System.err.println("Error loading book room screen: " + e.getMessage());
        }
    }

    @FXML
    private void handleLogout() {

        System.out.println("Logging out...");

        try {
            loadScene("login.fxml", "Login - Hotel Booking System");
        } catch (IOException e) {
            System.err.println("Error loading login screen: " + e.getMessage());
        }
    }

    private void loadScene(
            String fxml,
            String title
    ) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage currentStage = (Stage) usernameLabel.getScene().getWindow();
        currentStage.setScene(scene);
        currentStage.setTitle(title);
    }
}
