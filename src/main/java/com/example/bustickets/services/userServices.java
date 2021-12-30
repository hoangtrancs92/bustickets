package com.example.bustickets.services;

import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userServices {
    public  void addUsers(users u) throws SQLException {
        try {
            Connection cnn = JdbcUtils.getCnn();
            PreparedStatement stm1 = cnn.prepareStatement("INSERT INTO users(name,password,email,phone,address,birthday,sex) VALUES(?,?,?,?,?,?,?)");
            stm1.setString(1,u.getName());
            stm1.setString(2,u.getPassword());
            stm1.setString(3,u.getEmail());
            stm1.setString(4,u.getPhone());
            stm1.setString(5,u.getAddress());
            stm1.setString(6,u.getBirthday());
            stm1.setInt(7,u.getSex());
            stm1.executeUpdate();

            stm1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
