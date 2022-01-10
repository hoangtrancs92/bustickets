package com.example.bustickets.services;

import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.cars;
import com.example.bustickets.model.employees;
import com.example.bustickets.model.users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class employeeServices {
    public List<users> getEmployees() throws SQLException {
        List<users> result = new ArrayList<>();
        try(Connection conn = JdbcUtils.getCnn()){
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM bustickets_db.users where(role = 2)");
            while (rs.next()){
               users info_employees = new users(rs.getInt(1),rs.getString(2),rs.getString(4));
                result.add( info_employees);
            }
            rs.close();
            stm.close();
            conn.close();

        }
        return result;
    }
}
