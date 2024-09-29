package com.vinicius.hotelbookingsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Image icon = new Image(MainApp.class.getResourceAsStream("images/startu-procket.png"));

        scene.getStylesheets().add(MainApp.class.getResource("css/login.css").toExternalForm());
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setTitle("Login - Hotel Booking System");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}