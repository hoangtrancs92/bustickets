package com.example.bustickets.services;

import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.tickets;

import java.sql.*;
import java.util.ArrayList;

public class createticketsServices {
    private static final int TXT_NUMBER = 8;
    public  void addSetOfTickets(tickets t) throws SQLException {
            try {
                Connection cnn = JdbcUtils.getCnn();
                PreparedStatement stm1 = cnn.prepareStatement("INSERT INTO tickets(location_start,location_end,quanlity,date_start,price,employees_id,time_start,cars_id) VALUES(?,?,?,?,?,?,?,?) ");
                stm1.setString(1,t.getLocation_start());
                stm1.setString(2, t.getLocation_end());
                stm1.setInt(3,t.getQuanlity());
                stm1.setString(4,t.getDate_start());
                stm1.setString(5,t.getPrice());
                stm1.setInt(6,t.getEmployees_id());
                stm1.setString(7,t.getTime_start());
                stm1.setInt(8, t.getCars_id());
                stm1.executeUpdate();

                stm1.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    public ArrayList<tickets> idSetOffTickets() throws SQLException{
        ArrayList<tickets> arrayList = new ArrayList<>();
        try {
            Connection cnn = JdbcUtils.getCnn();
            ResultSet rs = cnn.createStatement().executeQuery("SELECT MAX(idtickets) FROM tickets");
            while (rs.next()){
                arrayList.add(new tickets(rs.getInt(1)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return arrayList;
    }
}