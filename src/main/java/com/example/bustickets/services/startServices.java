package com.example.bustickets.services;

import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.starting_points;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class startServices {
    public List<starting_points> getPoint() throws SQLException {
        List<starting_points> result = new ArrayList<>();
        try(Connection conn = JdbcUtils.getCnn()){
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM  starting_points");
            while (rs.next()){
                starting_points info_point = new starting_points(rs.getInt(1),rs.getString(2));
                result.add(info_point);
            }
        }
        return result;
    }
}
