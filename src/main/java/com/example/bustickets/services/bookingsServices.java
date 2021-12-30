package com.example.bustickets.services;
import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.tickets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
}
