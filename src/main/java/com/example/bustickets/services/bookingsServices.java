package com.example.bustickets.services;
import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.bookings;
import com.example.bustickets.model.detail_tickets;
import com.example.bustickets.model.tickets;
import com.example.bustickets.model.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class bookingsServices {
    public ArrayList<tickets> detailTickets() throws SQLException{
        ArrayList<tickets> detail = new ArrayList<>();
        try {
            Connection cnn = JdbcUtils.getCnn();
            ResultSet rs = cnn.createStatement().executeQuery("SELECT cars.code_car,tickets.*,cars.number_seat FROM cars,tickets where cars.idcars = tickets.cars_id;");
            while (rs.next()){
                detail.add(new tickets( rs.getString(9),
                                        rs.getString(1),
                                        rs.getString(3),
                                        rs.getString(4),
                                        rs.getString(6),
                                        rs.getString(7),
                                        rs.getInt(2),
                                        rs.getInt(11)
                        ));

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return detail;
    }
//    INSERT INTO bookings(code, status, users_id) VALUES ('?', '?', '?' )
    public void addBookingUser(users customer, bookings booking) throws SQLException{
        try {
            Connection cnn = JdbcUtils.getCnn();
            PreparedStatement stm1 = cnn.prepareStatement("INSERT INTO bookings(code, status, users_id) VALUES (?, ?, ?) ");
            stm1.setString(1,booking.getCode());
            stm1.setInt(2, booking.getStatus());
            stm1.setInt(3,booking.getUsers_id());
            stm1.executeUpdate();

            stm1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
