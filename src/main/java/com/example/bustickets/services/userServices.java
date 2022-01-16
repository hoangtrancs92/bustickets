package com.example.bustickets.services;

import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.tickets;
import com.example.bustickets.model.users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userServices {
    final String secretKey = "12345678";

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
    public void addUserOffline(users us){
        try {
            Connection cnn = JdbcUtils.getCnn();
            PreparedStatement stm1 = cnn.prepareStatement("INSERT INTO users(name,phone,role) values (?,?,'1')");
            stm1.setString(1,us.getName());
            stm1.setString(2,us.getPhone());
            stm1.executeUpdate();
            stm1.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public List<users> getUser() throws SQLException{
        List<users> result = new ArrayList<>();
        try(Connection cnn = JdbcUtils.getCnn()){
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT users.* FROM bustickets_db.users WHERE users.password is not null");
        while (rs.next()){
            users u = new users(rs.getInt("iduser"), rs.getString("name"), rs.getString("password"),
                    rs.getString("email"), rs.getString("phone"),
                    rs.getString("address"), rs.getString("birthday"),
                    rs.getInt("sex"),rs.getInt("role"));
            result.add(u);
        }
        stm.close();
    }
            return result;

    }
    public users getUserById(int id) throws SQLException{
        users u = new users();
        try(Connection cnn = JdbcUtils.getCnn()){
            PreparedStatement stm = cnn.prepareCall("SELECT * FROM  users WHERE iduser=?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                u = new users(rs.getInt("iduser"), rs.getString("name"), rs.getString("password"),
                        rs.getString("email"), rs.getString("phone"),
                        rs.getString("address"), rs.getString("birthday"),
                        rs.getInt("sex"),rs.getInt("role"));
            }
            stm.close();
        }
        return u;

    }
    public int  getMaxIdUsers(){
        int id = 0;
        try {
            Connection cnn = JdbcUtils.getCnn();
            ResultSet rs = cnn.createStatement().executeQuery("SELECT MAX(iduser) FROM users");
            while (rs.next()){
//                arrayList.add(new tickets(rs.getInt(1)));
                id = rs.getInt(1);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return id;
    }


    //
    public ObservableList<users> observableList() {
        ObservableList<users> result = FXCollections.observableArrayList();
        try {
            Connection cnn = JdbcUtils.getCnn();
            ResultSet rs = cnn.createStatement().executeQuery(" SELECT * FROM bustickets_db.users where(role = 1) and users.email is not null");

            while (rs.next()) {
                result.add(new users(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
