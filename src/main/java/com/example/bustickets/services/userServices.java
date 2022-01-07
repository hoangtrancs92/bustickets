package com.example.bustickets.services;

import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userServices {
    public  void addUsers(users u) throws SQLException {
        try {
            Connection cnn = JdbcUtils.getCnn();
            PreparedStatement stm1 = cnn.prepareStatement("INSERT INTO users(name,password,email,phone,address,birthday,sex,role) VALUES(?,?,?,?,?,?,?,'1')");
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
    public List<users> getUser() throws SQLException{
        List<users> result = new ArrayList<>();
        try(Connection cnn = JdbcUtils.getCnn()){
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM  users");
        while (rs.next()){
            users u = new users(rs.getInt("iduser"), rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("email"), rs.getString("phone"),
                    rs.getString("address"), rs.getString("birthday"),
                    rs.getInt("sex"),rs.getInt("role"));
            result.add(u);
        }
    }
            return result;

    }
}
