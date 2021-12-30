package com.example.bustickets;

import com.example.bustickets.model.detail_tickets;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class items2Controller implements Initializable {


    @FXML
    private CheckBox seat_checkbox;

    private detail_tickets detailTickets;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int i = 0;
        while (seat_checkbox.isSelected()){
            System.out.println(i++);
        }

    }
    public void setData(detail_tickets detail){
        this.detailTickets = detail;
        seat_checkbox.setSelected(false);
        if (detail.getId_bookings() != 0){
            seat_checkbox.setSelected(true);
            seat_checkbox.setDisable(true);
            seat_checkbox.setStyle("selected-box-color: #ff7979;");
        }
    }
    public int getData(){
        if (seat_checkbox.isSelected())
            return 1;
        else
            return 0;
    }
}
