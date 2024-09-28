module com.vpteruel.logindesktopapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.vpteruel.logindesktopapp to javafx.fxml;
    exports com.vpteruel.logindesktopapp;
}