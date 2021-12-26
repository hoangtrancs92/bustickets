package com.example.bustickets;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.example.bustickets.model.tickets;
import com.example.bustickets.services.bookingsServices;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

import java.sql.SQLException;
import java.util.ArrayList;

public class itemsController {

    @FXML
    private Label carHeader_label;

    @FXML
    private Label dateStart_label;

    @FXML
    private Label locationEnd_label;

    @FXML
    private Label locationStart_label;

    @FXML
    private Button price_button;

    @FXML
    private Label time_label;

    @FXML
    private ImageView imgview;

    private tickets ticket;
    private String car_1 = "59OU001";
    private String car_2 = "59OU002";
    public void setData(tickets ticket) {
        this.ticket= ticket;
        if (ticket.getCode_car().equals(car_1)){
            price_button.setStyle("-fx-border-color:#27ae60; -fx-hovered-background: #27ae60; " +
                                            "-fx-hovered-textfill: white; ");
            carHeader_label.setStyle("-fx-background-color: #27ae60");
            carHeader_label.setText(ticket.getCode_car());
            time_label.setText(ticket.getTime_start());
            dateStart_label.setText(ticket.getDate_start());
            locationEnd_label.setText(ticket.getLocation_end());
            locationStart_label.setText(ticket.getLocation_start());
            price_button.setText(ticket.getPrice());
        }
        else if (ticket.getCode_car().equals(car_2)){
            price_button.setStyle("-fx-border-color:#f6b93b; -fx-hovered-background: #f6b93b; " +
                    "-fx-hovered-textfill: white; ");
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
}
