package com.example.bustickets.services;

import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.tickets;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class managerticketsServices {
    public  ObservableList<tickets> observableList(){
        ObservableList<tickets> result = FXCollections.observableArrayList();
        try {
            Connection cnn = JdbcUtils.getCnn();
            ResultSet rs = cnn.createStatement().executeQuery("select seats.code, tickets.quanlity,employees.name,tickets.location_start,tickets.location_end,tickets.date_start, tickets.time_start ,code_car from cars, tickets, seats,employees where cars.idcars=seats.idseats and tickets.idtickets= seats.idseats\n");

            while (rs.next()){
                result.add(new tickets(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7),
                        rs.getString(8)
                        ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  result;
    }

}
