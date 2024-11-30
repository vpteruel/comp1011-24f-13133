package com.vinicius.rickandmorty.controllers;

import com.vinicius.rickandmorty.utils.LoaderUtil;
import com.vinicius.rickandmorty.enums.View;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class MainController {

    @FXML
    private Pane characterPane;

    @FXML
    public void initialize() {
        showDashboard();
    }

    @FXML
    public void showDashboard() {
        LoaderUtil.loadContentView(characterPane, View.DASHBOARD);
    }

    @FXML
    public void showCharacters() {
        LoaderUtil.loadContentView(characterPane, View.SEARCHER);
    }

    @FXML
    public void showEpisode() {
        LoaderUtil.loadContentView(characterPane, View.EPISODE);
    }
}