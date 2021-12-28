package com.example.bustickets;

import com.example.bustickets.services.carServices;
import com.example.bustickets.services.employeeServices;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class bookingseatsController  extends itemsController implements Initializable {
//    public static void main(String arg[]){
        itemsController imC = new itemsController();
//        System.out.println(imC.car_1);
//    }


    @FXML
    private Label test;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
