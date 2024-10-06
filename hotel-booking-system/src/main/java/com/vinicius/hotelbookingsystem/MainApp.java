package com.vinicius.hotelbookingsystem;

import com.vinicius.hotelbookingsystem.infra.SQLiteDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import org.sqlite.JDBC;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        SQLiteDB.setupDatabase();

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
        checkDrivers();
        launch();
    }

    private static boolean checkDrivers() {

        try {
            Class.forName("org.sqlite.JDBC");
            DriverManager.registerDriver(new JDBC());
            return true;
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            Logger.getAnonymousLogger().log(Level.SEVERE, LocalDateTime.now() + ": Could not start SQLite Drivers");
            return false;
        }
    }
}