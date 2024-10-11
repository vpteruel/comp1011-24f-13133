package com.vinicius.fxcamera;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    @FXML
    private Label fileLabel;

    @FXML
    private ImageView cameraImageView;

    @FXML
    private Button submitCameraButton;

    @FXML
    public void initialize() {
        SpinnerValueFactory<Double> priceValueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10000, 100, 1);
        priceSpinner.setValueFactory(priceValueFactory);

        makeDropdown.getItems().addAll("Brand A", "Brand B", "Brand C");
        osDropdown.getItems().addAll("OS 1", "OS 2", "OS 3");

        uploadImageButton.setOnAction(e -> handleImageUpload());
    }

    private void handleImageUpload() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload Camera Image");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        Stage stage = (Stage) uploadImageButton.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            fileLabel.setText(selectedFile.getName());
            Image image = new Image(selectedFile.toURI().toString());
            cameraImageView.setImage(image);  // Display the image in ImageView
        } else {
            fileLabel.setText("No file chosen");
        }
    }

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