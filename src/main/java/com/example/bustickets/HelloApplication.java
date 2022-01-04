package com.example.bustickets;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static final String CURRENCY = " vnđ";
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bookings_tickets.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("OUBus Company");
        stage.setScene(scene);
//        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}