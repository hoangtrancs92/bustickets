package com.example.bustickets.services;

import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.cars;
import com.example.bustickets.model.detail_tickets;
import com.example.bustickets.model.tickets;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class detailticketsServices {


    public  void AddDetailTickets(detail_tickets detailTickets) throws SQLException {
        try {
            Connection cnn = JdbcUtils.getCnn();
            PreparedStatement stm1 = cnn.prepareStatement("INSERT INTO detail_tickets (iddetail_tickets, id_tickets) VALUES (?, ?) ");
            stm1.setString(1,detailTickets.getIddetail_tickets());
            stm1.setInt(2, detailTickets.getId_tickets());
            stm1.executeUpdate();
            stm1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
