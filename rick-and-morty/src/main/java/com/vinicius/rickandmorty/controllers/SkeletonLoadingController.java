package com.vinicius.rickandmorty.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class SkeletonLoadingController {

    @FXML
    private Rectangle rectangle1;

    @FXML
    private Rectangle rectangle2;

    @FXML
    private Rectangle rectangle3;

    @FXML
    private Rectangle rectangle4;

    @FXML
    private Rectangle rectangle5;

    @FXML
    private Rectangle rectangle6;

    @FXML
    private Rectangle rectangle7;

    @FXML
    public void initialize() {
        Rectangle[] rectangles = {
                rectangle1,
                rectangle2,
                rectangle3,
                rectangle4,
                rectangle5,
                rectangle6,
                rectangle7
        };

        for (Rectangle rectangle : rectangles) {

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(rectangle.fillProperty(), Color.LIGHTGRAY)),
                    new KeyFrame(Duration.seconds(1), new KeyValue(rectangle.fillProperty(), Color.DARKGRAY)),
                    new KeyFrame(Duration.seconds(2), new KeyValue(rectangle.fillProperty(), Color.LIGHTGRAY))
            );

            // Set the timeline to repeat indefinitely
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.setAutoReverse(true);
            timeline.play();
        }
    }
}
