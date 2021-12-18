module com.example.bustickets {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bustickets to javafx.fxml;
    exports com.example.bustickets;
    exports com.example.bustickets.model;
    opens com.example.bustickets.model to javafx.fxml;
    requires  java.sql;
    requires mysql.connector.java;
    requires junit;
    requires org.junit.jupiter.api;
}