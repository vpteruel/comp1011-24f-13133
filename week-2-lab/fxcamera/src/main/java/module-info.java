module com.vinicius.fxcamera {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.vinicius.fxcamera to javafx.fxml;
    exports com.vinicius.fxcamera;
}