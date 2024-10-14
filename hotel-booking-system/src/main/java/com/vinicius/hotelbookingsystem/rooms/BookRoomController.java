package com.vinicius.hotelbookingsystem.rooms;

import com.vinicius.hotelbookingsystem.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class BookRoomController {

    @FXML
    private TextField customerNameField;

    @FXML
    private ComboBox<RoomEntity> roomSelectionBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    public void initialize() {

        RoomService roomService = new RoomService();
        roomSelectionBox.getItems().addAll(roomService.getAvailableRooms());
    }

    @FXML
    public void handleBookRoom() {

        RoomService roomService = new RoomService();

        String customerName = customerNameField.getText();
        RoomEntity selectedRoom = roomSelectionBox.getValue();
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();

        if (customerName.isEmpty() || selectedRoom == null || startDate == null || endDate == null) {
            System.out.println("Please fill out all fields.");
            return;
        }

        boolean isBooked = roomService.bookRoom(selectedRoom.getId(), customerName, startDate, endDate);
        String message = isBooked
                ? "Room booked successfully."
                : "Failed to book the room.";

        System.out.println(message);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Book Room");
        alert.setHeaderText(null);
        alert.setContentText("");
        alert.showAndWait();
    }

    @FXML
    public void handleCancel() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("welcome.fxml"));
            Stage currentStage = (Stage) customerNameField.getScene().getWindow();
            currentStage.setScene(new Scene(fxmlLoader.load(), 800, 600));
            currentStage.setTitle("Welcome - Hotel Booking System");
        } catch (IOException e) {
            System.err.println("Error loading welcome screen: " + e.getMessage());
        }
    }
}
