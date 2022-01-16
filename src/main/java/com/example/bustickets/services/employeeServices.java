package com.example.bustickets.services;

import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.cars;
import com.example.bustickets.model.employees;
import com.example.bustickets.model.tickets;
import com.example.bustickets.model.users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class employeeServices {
    public ObservableList<users> observableList() {
        ObservableList<users> result = FXCollections.observableArrayList();
        try {
            Connection cnn = JdbcUtils.getCnn();
            ResultSet rs = cnn.createStatement().executeQuery(" SELECT * FROM bustickets_db.users where(role = 2)");

            while (rs.next()){
                result.add(new users(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  result;
    }
}
