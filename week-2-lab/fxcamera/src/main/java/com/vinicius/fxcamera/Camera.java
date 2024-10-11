package com.vinicius.fxcamera;

public class Camera {
    private String make;
    private String model;
    private String os;
    private String screenSize;
    private double memory;
    private String fromCamera;
    private String rearCamera;
    private double price;

    // Getters and Setter methods

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        if (make == null || make.trim().isEmpty()) {
            throw new IllegalArgumentException("Make cannot be null or empty.");
        }
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty.");
        }
        this.model = model;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        if (os == null || os.trim().isEmpty()) {
            throw new IllegalArgumentException("Operating System cannot be null or empty.");
        }
        this.os = os;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        if (screenSize == null || !screenSize.matches("\\d+(\\.\\d+)?")) {  // Check if it's a number or decimal
            throw new IllegalArgumentException("Screen Size must be a valid number.");
        }
        this.screenSize = screenSize;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        if (memory < 0 || memory > 256) {
            throw new IllegalArgumentException("Memory must be between 0 and 256 GB.");
        }
        this.memory = memory;
    }

    public String getFromCamera() {
        return fromCamera;
    }

    public void setFromCamera(String fromCamera) {
        if (fromCamera == null || fromCamera.trim().isEmpty()) {
            throw new IllegalArgumentException("Front Camera details cannot be null or empty.");
        }
        this.fromCamera = fromCamera;
    }

    public String getRearCamera() {
        return rearCamera;
    }

    public void setRearCamera(String rearCamera) {
        if (rearCamera == null || rearCamera.trim().isEmpty()) {
            throw new IllegalArgumentException("Rear Camera details cannot be null or empty.");
        }
        this.rearCamera = rearCamera;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    // Constructor

    public Camera(String make, String model, String os, String screenSize, double memory,
                  String fromCamera, String rearCamera, double price) {
        setMake(make);
        setModel(model);
        setOs(os);
        setScreenSize(screenSize);
        setMemory(memory);
        setFromCamera(fromCamera);
        setRearCamera(rearCamera);
        setPrice(price);
    }
}
