module com.example.bustickets {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bustickets to javafx.fxml;
    exports com.example.bustickets;
    requires  java.sql;

}