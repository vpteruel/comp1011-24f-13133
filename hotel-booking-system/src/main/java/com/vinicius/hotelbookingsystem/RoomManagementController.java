package com.vinicius.hotelbookingsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class RoomManagementController {

    @FXML
    private TableView<Room> roomTable;

    @FXML
    private TableColumn<Room, String> roomNumberColumn;

    @FXML
    private TableColumn<Room, String> roomTypeColumn;

    @FXML
    private TableColumn<Room, Double> priceColumn;

    @FXML
    private Button addRoomButton;

    @FXML
    private Button editRoomButton;

    @FXML
    private Button deleteRoomButton;

    @FXML
    private Button backButton;

    @FXML
    public void initialize() {
        // Initialize the table columns
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        roomTypeColumn.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // You can load room data into the table here (hardcoded data for example)
        // roomTable.getItems().add(new Room("101", "Single", 150.0));
    }

    @FXML
    private void handleAddRoom() {
        openRoomForm(null);
    }

    @FXML
    private void handleEditRoom() {
        Room selectedRoom = roomTable.getSelectionModel().getSelectedItem();
        if (selectedRoom != null) {
            openRoomForm(selectedRoom);
        } else {
            showAlert("Error", "No room selected.");
        }
    }

    @FXML
    private void handleDeleteRoom() {
        Room selectedRoom = roomTable.getSelectionModel().getSelectedItem();
        if (selectedRoom != null) {
            roomTable.getItems().remove(selectedRoom);
            showAlert("Room Deleted", "Deleted room: " + selectedRoom.getRoomNumber());
        } else {
            showAlert("Error", "No room selected.");
        }
    }

    @FXML
    private void handleBack() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("welcome.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.setScene(scene);
            currentStage.setTitle("Welcome - Hotel Booking System");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void openRoomForm(Room room) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("room_form.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 300);

            RoomFormController controller = fxmlLoader.getController();
            if (room != null) {
                controller.setRoomData(room);
            }

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(room == null ? "Add Room" : "Edit Room");
            stage.setResizable(false);
            stage.showAndWait();

            Room newRoom = controller.getRoom();
            if (newRoom != null && !roomTable.getItems().contains(newRoom)) {
                roomTable.getItems().add(newRoom);
            }

            roomTable.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
