package com.vinicius.rickandmorty.utils;

import com.vinicius.rickandmorty.MainApp;
import com.vinicius.rickandmorty.enums.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoaderUtil {

    public static FXMLLoader loadContentView(Pane contentPane, View view) {
        return loadView(contentPane, view);
    }

    public static FXMLLoader loadView(View view) {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource(view.getPath()));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(view.getTitle());
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            return loader;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static FXMLLoader loadView(Pane pane, View view) {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource(view.getPath()));
            Node nodeView = loader.load();
            pane.getChildren().clear();
            pane.getChildren().add(nodeView);
            return loader;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
