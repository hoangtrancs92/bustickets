package com.example.bustickets.services;

import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.cars;
import com.example.bustickets.model.employees;
import com.example.bustickets.model.tickets;
import com.example.bustickets.model.users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
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
    public users getroleUsers(int roles){
        users u = null;
        try( Connection cnn = JdbcUtils.getCnn() ) {
            PreparedStatement stm = cnn.prepareCall("SELECT * FROM bustickets_db.users where(role = ?)");
            stm.setString(1, String.valueOf(roles));
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                u = new users(rs.getInt(1),rs.getString(4),rs.getInt(9));
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
    public List<users> getuser() throws SQLException {
        List<users> result = new ArrayList<>();
        try(Connection conn = JdbcUtils.getCnn()){
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM bustickets_db.users where(role = 2) ");
            while (rs.next()){
                users us = new users(rs.getString(2),rs.getString(4),rs.getInt(9),rs.getString(5));
                result.add(us);
            }
        }
        return result;
    }
}
