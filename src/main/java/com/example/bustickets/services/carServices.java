package com.example.bustickets.services;

import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.cars;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class carServices {
    public List<cars> getCars() throws SQLException {
        List<cars> result = new ArrayList<>();
        try(Connection conn = JdbcUtils.getCnn()){
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM  cars");
            while (rs.next()){
                cars info_cars = new cars(rs.getInt(1),rs.getString(2),rs.getInt(3));
                result.add(info_cars);
            }
        }
            return result;
    }
}
