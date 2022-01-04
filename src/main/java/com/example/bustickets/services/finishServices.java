package com.example.bustickets.services;

import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.finishing_points;
import com.example.bustickets.model.starting_points;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class finishServices {
    public List<finishing_points> getPointEnd() throws SQLException {
        List<finishing_points> result = new ArrayList<>();
        try(Connection conn = JdbcUtils.getCnn()){
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM  finishing_points");
            while (rs.next()){
                finishing_points info_point = new finishing_points(rs.getInt(1),rs.getString(2));
                result.add(info_point);
            }
        }
        return result;
    }
}
