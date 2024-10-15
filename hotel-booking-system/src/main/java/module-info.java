module com.vinicius.hotelbookingsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires mysql.connector.j;
    requires java.sql;
    requires java.dotenv;

    exports com.vinicius.hotelbookingsystem;
    opens com.vinicius.hotelbookingsystem to javafx.fxml;
    exports com.vinicius.hotelbookingsystem.common;
    opens com.vinicius.hotelbookingsystem.common to javafx.fxml;
    exports com.vinicius.hotelbookingsystem.infra;
    opens com.vinicius.hotelbookingsystem.infra to javafx.fxml;
    exports com.vinicius.hotelbookingsystem.rooms;
    opens com.vinicius.hotelbookingsystem.rooms to javafx.fxml;
    exports com.vinicius.hotelbookingsystem.users;
    opens com.vinicius.hotelbookingsystem.users to javafx.fxml;
}