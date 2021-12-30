package com.example.bustickets;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.example.bustickets.model.tickets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.w3c.dom.events.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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

    @FXML
    public void click(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        mylistener.onClickListener(ticket);
    }

    private tickets ticket;
    Mylistener mylistener;

    public String car_1 = "59OU001";
    public String car_2 = "59OU002";
    public void setData(tickets ticket,Mylistener mylistener) throws FileNotFoundException, ParseException {
        this.ticket = ticket;
        this.mylistener = mylistener;
            if (ticket.getCode_car().equals(car_1)) {
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
                price_button.setText(ticket.getPrice()+HelloApplication.CURRENCY);
            } else if (ticket.getCode_car().equals(car_2)) {
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
                price_button.setText(ticket.getPrice()+HelloApplication.CURRENCY);
            } else {
                price_button.setStyle("-fx-border-color:#706fd3; -fx-hovered-background: #706fd3; " +
                        "-fx-hovered-textfill: white; ");
                carHeader_label.setStyle("-fx-background-color: #706fd3");
                carHeader_label.setText(ticket.getCode_car());
                time_label.setText(ticket.getTime_start());
                dateStart_label.setText(ticket.getDate_start());
                locationEnd_label.setText(ticket.getLocation_end());
                locationStart_label.setText(ticket.getLocation_start());
                price_button.setText(ticket.getPrice()+HelloApplication.CURRENCY);
            }

        }
}
