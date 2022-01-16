package com.example.bustickets.services;

import com.example.bustickets.alerts.totalMoney;
import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.tickets;
import com.example.bustickets.model.users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TotalMoneyServices {
    public ObservableList<totalMoney> observableList(users u){
        ObservableList<totalMoney> result = FXCollections.observableArrayList();
        try {
            Connection cnn = JdbcUtils.getCnn();
            ResultSet rs = cnn.createStatement().executeQuery("SELECT users.name,users.phone, bookings.idbookings,detail_tickets.iddetail_tickets,tickets.price,tickets.date_start,tickets.time_start,cars.code_car\n" +
                    "FROM users inner join bookings on users.iduser = bookings.users_id inner join detail_tickets on bookings.idbookings = detail_tickets.id_bookings\n" +
                    "inner join tickets on tickets.idtickets = detail_tickets.id_tickets inner join cars on tickets.cars_id = cars.idcars where users.iduser = '"+u.getIdusers()+"'");

            while (rs.next()){
                result.add(new totalMoney(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)

                ));
                System.out.println(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  result;
    }
}
