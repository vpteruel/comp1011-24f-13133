package com.vinicius.hotelbookingsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RoomFormController {

    @FXML
    private TextField roomNumberField;

    @FXML
    private TextField roomTypeField;

    @FXML
    private TextField priceField;

    @FXML
    private Button saveButton;

    private Room room;
    private boolean isEditMode = false;

    public void setRoomData(Room room) {

        if (room != null) {
            this.room = room;
            roomNumberField.setText(room.getRoomNumber());
            roomTypeField.setText(room.getRoomType());
            priceField.setText(String.valueOf(room.getPrice()));
            isEditMode = true;
        }
    }

    @FXML
    private void handleSave() {

        String roomNumber = roomNumberField.getText();
        String roomType = roomTypeField.getText();
        double price;

        if (roomNumber.isEmpty() || roomType.isEmpty()) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }

        try {
            price = Double.parseDouble(priceField.getText());
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid price. Please enter a valid number.");
            return;
        }

        if (isEditMode) {
            room.setRoomNumber(roomNumber);
            room.setRoomType(roomType);
            room.setPrice(price);

            RoomService.editRoom(room);
        } else {
            room = new Room(roomNumber, roomType, price);

            RoomService.addRoom(room);
        }

        closeForm();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void closeForm() {
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

    public Room getRoom() {
        return room;
    }
}
