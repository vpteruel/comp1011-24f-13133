package com.vinicius.rickandmorty.controllers;

import com.vinicius.rickandmorty.models.Character;
import com.vinicius.rickandmorty.models.Episode;
import com.vinicius.rickandmorty.utils.ApiClient;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Optional;

public class EpisodeController {

    @FXML
    private Label episodeTitle;

    @FXML
    private Label episodeEpisode;

    @FXML
    private Label episodeCharactersCounter;

    public void loadEpisode(String episodeUrl) {
        ApiClient apiClient = new ApiClient();
        Optional<Episode> optionalEpisode = apiClient.getEpisode(episodeUrl);
        if (optionalEpisode.isPresent()) {
            Episode episode = optionalEpisode.get();

            episodeTitle.setText(episode.getName());
            episodeEpisode.setText(episode.getEpisode());
            episodeCharactersCounter.setText(String.valueOf(episode.getCharacters().size()));
        }
    }
}
