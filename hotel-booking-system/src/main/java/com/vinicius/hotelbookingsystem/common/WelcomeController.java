package com.vinicius.hotelbookingsystem.common;

import com.vinicius.hotelbookingsystem.MainApp;
import com.vinicius.hotelbookingsystem.users.UserPreferences;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {

    @FXML
    private Button dashboardButton;

    @FXML
    private Button roomManagementButton;

    @FXML
    private Button bookingManagementButton;

    @FXML
    private Button roomAvailabilityButton;

    @FXML
    private Label usernameLabel;

    @FXML
    public void initialize() {

        String username = UserPreferences.getUsername();

        if (username != null) {
            usernameLabel.setText(username);
        }
    }

    @FXML
    private void handleDashboard() {

        System.out.println("Navigating to Dashboard...");

        try {
            loadScene("dashboard.fxml", "Dashboard - Hotel Booking System");
        } catch (IOException e) {
            System.err.println("Error loading dashboard screen: " + e.getMessage());
        }
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

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Welcome to Booking System");
        alert.setHeaderText(null);
        alert.setContentText("Coming soon!");
        alert.showAndWait();

//        try {
//            loadScene("bookingManagement.fxml", "Booking Management - Hotel Booking System");
//        } catch (IOException e) {
//            System.err.println("Error loading booking management screen: " + e.getMessage());
//        }
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
            UserPreferences.removeUsername();
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
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 600);
        Stage currentStage = (Stage) usernameLabel.getScene().getWindow();
        currentStage.setScene(scene);
        currentStage.setTitle(title);
    }
}
