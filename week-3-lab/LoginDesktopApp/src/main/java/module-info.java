module com.vpteruel.logindesktopapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.vpteruel.logindesktopapp to javafx.fxml;
    exports com.vpteruel.logindesktopapp;
}