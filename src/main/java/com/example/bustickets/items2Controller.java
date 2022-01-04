package com.example.bustickets;

import com.example.bustickets.model.detail_tickets;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class items2Controller implements Initializable {


    @FXML
    private CheckBox seat_checkbox;

    private detail_tickets detailTickets;

    MyListenner_bookingsSeats myListenner_bookingsSeats;

    @FXML
    public void click(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        myListenner_bookingsSeats.onClickListener_bookingsSeats(detailTickets);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void setData(detail_tickets detail, MyListenner_bookingsSeats myListenner_bookingsSeats){
        this.myListenner_bookingsSeats = myListenner_bookingsSeats;
        this.detailTickets = detail;
        seat_checkbox.setSelected(false);
        if (detail.getId_bookings() != 0){
            seat_checkbox.setSelected(true);
            seat_checkbox.setDisable(true);
            seat_checkbox.setStyle("selected-box-color: #ff7979;");
        }
    }
    public int getData(detail_tickets detail){
        if (seat_checkbox.isSelected())
            return 1;
        else
            return 0;
    }
}
