module com.vinicius.hotelbookingsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.xerial.sqlitejdbc;

    opens com.vinicius.hotelbookingsystem to javafx.fxml;
    exports com.vinicius.hotelbookingsystem;
}