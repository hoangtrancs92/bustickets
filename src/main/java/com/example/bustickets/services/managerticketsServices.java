package com.example.bustickets.services;

import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.cars;
import com.example.bustickets.model.detail_tickets;
import com.example.bustickets.model.tickets;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class managerticketsServices {
    public  ObservableList<tickets> observableList(){
        ObservableList<tickets> result = FXCollections.observableArrayList();
        try {
            Connection cnn = JdbcUtils.getCnn();
            ResultSet rs = cnn.createStatement().executeQuery(" select tickets.*, users.name, cars.code_car from tickets, " +
                    "users, cars where users.iduser = tickets.users_id and cars.idcars = tickets.cars_id");

            while (rs.next()){
                result.add(new tickets(
                        rs.getString(1),
                        rs.getInt(4),
                        rs.getString(10),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(5),
                        rs.getString(7),
                        rs.getString(11)
                        ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  result;
    }
    public List<detail_tickets> getId() throws SQLException {
        List<detail_tickets> result = new ArrayList<>();
        try(Connection conn = JdbcUtils.getCnn()){
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM  detail_tickets");
            while (rs.next()){
                detail_tickets dt = new detail_tickets(rs.getString(1));
                result.add(dt);
            }
        }
        return result;
    }
}
