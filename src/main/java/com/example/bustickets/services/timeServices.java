package com.example.bustickets.services;

import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.finishing_points;
import com.example.bustickets.model.time;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class timeServices {
    public List<time> getTime() throws SQLException {
        List<time> result = new ArrayList<>();
        try(Connection conn = JdbcUtils.getCnn()){
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM  time");
            while (rs.next()){
                time info_time = new time(rs.getInt(1),rs.getString(2));
                result.add(info_time);
            }
        }
        return result;
    }
}
