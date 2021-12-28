package com.example.bustickets;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.example.bustickets.model.tickets;
import com.example.bustickets.services.bookingsServices;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class itemsController {

    @FXML
    public Label carHeader_label;

    @FXML
    public Label dateStart_label;

    @FXML
    protected Label locationEnd_label;

    @FXML
    protected Label locationStart_label;

    @FXML
    protected Button price_button;

    @FXML
    protected Label time_label;

    @FXML
    private ImageView imgview;

    private tickets ticket;
    public String car_1 = "59OU001";
    public String car_2 = "59OU002";
    public void setData(tickets ticket) throws FileNotFoundException {
        this.ticket= ticket;
        if (ticket.getCode_car().equals(car_1)){
            FileInputStream input = new FileInputStream("src/main/resources/com/example/bustickets/img/green_bus.png");
            Image image = new Image(input);
            price_button.setStyle("-fx-border-color:#27ae60; -fx-hovered-background: #27ae60; " +
                                            "-fx-hovered-textfill: white; ");
            carHeader_label.setStyle("-fx-background-color: #27ae60");
            imgview.setImage(image);
            carHeader_label.setText(ticket.getCode_car());
            time_label.setText(ticket.getTime_start());
            dateStart_label.setText(ticket.getDate_start());
            locationEnd_label.setText(ticket.getLocation_end());
            locationStart_label.setText(ticket.getLocation_start());
            price_button.setText(ticket.getPrice());
        }
        else if (ticket.getCode_car().equals(car_2)){
            FileInputStream input = new FileInputStream("src/main/resources/com/example/bustickets/img/yellow_bus.png");
            Image image = new Image(input);
            price_button.setStyle("-fx-border-color:#f6b93b; -fx-hovered-background: #f6b93b; " +
                    "-fx-hovered-textfill: white; ");
            imgview.setImage(image);
            carHeader_label.setStyle("-fx-background-color: #f6b93b");
            carHeader_label.setText(ticket.getCode_car());
            time_label.setText(ticket.getTime_start());
            dateStart_label.setText(ticket.getDate_start());
            locationEnd_label.setText(ticket.getLocation_end());
            locationStart_label.setText(ticket.getLocation_start());
            price_button.setText(ticket.getPrice());
        }
        else{
            price_button.setStyle("-fx-border-color:#706fd3; -fx-hovered-background: #706fd3; " +
                    "-fx-hovered-textfill: white; ");
            carHeader_label.setStyle("-fx-background-color: #706fd3");
            carHeader_label.setText(ticket.getCode_car());
            time_label.setText(ticket.getTime_start());
            dateStart_label.setText(ticket.getDate_start());
            locationEnd_label.setText(ticket.getLocation_end());
            locationStart_label.setText(ticket.getLocation_start());
            price_button.setText(ticket.getPrice());
        }

    }
    @FXML
    private Label test;
    @FXML
    void switch_booking_seats(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent fxmlLoader;
        fxmlLoader = FXMLLoader.load(getClass().getResource("booking_seats.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
}
