package com.example.bustickets.services;

import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.cars;
import com.example.bustickets.model.employees;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class employeeServices {
    public List<employees> getEmployees() throws SQLException {
        List<employees> result = new ArrayList<>();
        try(Connection conn = JdbcUtils.getCnn()){
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM  employees");
            while (rs.next()){
                employees info_employees = new employees(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                result.add( info_employees);
            }
            rs.close();
            stm.close();
            conn.close();

        }
        return result;
    }
}
