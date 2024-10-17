package com.vinicius.hotelbookingsystem.common;

import com.vinicius.hotelbookingsystem.MainApp;
import com.vinicius.hotelbookingsystem.rooms.RoomService;
import com.vinicius.hotelbookingsystem.users.UserPreferences;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    private Button backButton;

    @FXML
    private BarChart<String, Number> roomChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    public void initialize() {
        loadRoomData();
    }

    @FXML
    private void handleBack() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("welcome.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 800, 600);
            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.setScene(scene);
            currentStage.setTitle("Welcome - Hotel Booking System");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void loadRoomData() {
        int availableRooms = RoomService.getAvailableRoomCount();
        int bookedRooms = RoomService.getBookedRoomCount();

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Room Status");

        series.getData().add(new XYChart.Data<>("Available", availableRooms));
        series.getData().add(new XYChart.Data<>("Booked", bookedRooms));

        roomChart.getData().add(series);
    }
}
