package com.vpteruel.fxcamera;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class CameraController {

    @FXML
    private ComboBox<String> makeDropdown;

    @FXML
    private TextField modelInput;

    @FXML
    private ComboBox<String> osDropdown;

    @FXML
    private TextField screenSizeInput;

    @FXML
    private Slider memorySlider;

    @FXML
    private TextField fromCameraInput;

    @FXML
    private TextField rearCameraInput;

    @FXML
    private Spinner<Double> priceSpinner;

    @FXML
    private Button uploadImageButton;

    // This method will be called once the controller is initialized
    @FXML
    public void initialize() {
        // Set up Spinner for Price input
        SpinnerValueFactory<Double> priceValueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10000, 100, 1);
        priceSpinner.setValueFactory(priceValueFactory);

        // Set up some default values (optional)
        makeDropdown.getItems().addAll("Brand A", "Brand B", "Brand C");
        osDropdown.getItems().addAll("OS 1", "OS 2", "OS 3");

        // Add button functionality for uploading an image
        uploadImageButton.setOnAction(e -> handleImageUpload());
    }

    // Functionality for handling image upload
    private void handleImageUpload() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload Camera Image");

        // Restrict file type to images
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        // Open the file chooser dialog
        Stage stage = (Stage) uploadImageButton.getScene().getWindow(); // Get the current window
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            // Handle the uploaded file (for example, save the path or display the image)
            System.out.println("File selected: " + selectedFile.getAbsolutePath());
        } else {
            System.out.println("File selection cancelled.");
        }
    }

    // Getters for retrieving input values (if needed elsewhere in the application)
    public String getMake() {
        return makeDropdown.getValue();
    }

    public String getModel() {
        return modelInput.getText();
    }

    public String getOS() {
        return osDropdown.getValue();
    }

    public String getScreenSize() {
        return screenSizeInput.getText();
    }

    public double getMemory() {
        return memorySlider.getValue();
    }

    public String getFromCamera() {
        return fromCameraInput.getText();
    }

    public String getRearCamera() {
        return rearCameraInput.getText();
    }

    public double getPrice() {
        return priceSpinner.getValue();
    }
}