module com.vinicius.question20 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.vinicius.question20 to javafx.fxml;
    exports com.vinicius.question20;
}