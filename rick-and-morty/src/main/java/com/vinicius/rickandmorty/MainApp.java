package com.vinicius.rickandmorty;

import com.vinicius.rickandmorty.utils.UserPreferences;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new UserPreferences().removeCharacter();

        Image icon = new Image(Objects.requireNonNull(MainApp.class.getResourceAsStream("images/app-icon.png")));
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("views/main.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 1024, 728);
        stage.setTitle("Rick and Morty API");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(icon);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}