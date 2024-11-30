module com.vinicius.rickandmorty {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.google.gson;
    requires java.prefs;

    exports com.vinicius.rickandmorty;
    opens com.vinicius.rickandmorty to javafx.fxml;
    exports com.vinicius.rickandmorty.models;
    opens com.vinicius.rickandmorty.models to javafx.fxml;
    exports com.vinicius.rickandmorty.utils;
    opens com.vinicius.rickandmorty.utils to javafx.fxml;
    exports com.vinicius.rickandmorty.controllers;
    opens com.vinicius.rickandmorty.controllers to javafx.fxml;
    opens com.vinicius.rickandmorty.views to javafx.fxml;
    exports com.vinicius.rickandmorty.enums;
    opens com.vinicius.rickandmorty.enums to javafx.fxml;
}