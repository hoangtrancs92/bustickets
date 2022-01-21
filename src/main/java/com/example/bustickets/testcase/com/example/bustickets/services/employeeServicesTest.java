package com.example.bustickets.services;

import com.example.bustickets.model.cars;
import com.example.bustickets.model.users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class employeeServicesTest {
    employeeServices emp = new employeeServices();

    // kiểm tra roles nhân viên
    @Test
    void getuser() {
        try {
            List<users> u = emp.getuser();
                for (int i = 0; i < u.size();i++){
                    Assertions.assertEquals(u.get(i).getRole(), 2);
                    System.out.println("Thanh cong");
                }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // kiểm tra email cuối
    @Test
    void getCheckEmailOnly(){
        try {
            List<users> u = emp.getuser();
            for (int i = 0; i < u.size()-1; i++){
                Assertions.assertNotEquals(u.get(i).getEmail(),u.get(u.size()-1).getEmail());
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // kiểm tra email từ đầu
    @Test
    void getCheckAllEmailOnly(){
        try {
            List<users> u = emp.getuser();
            for (int i = 0; i < u.size();i++ ){
                String email = u.get(i).getEmail();
                for (int j = i+1; j < u.size();j++){
                    Assertions.assertNotEquals(u.get(j).getEmail(),email);
                    System.out.println(u.get(j).getEmail() + "##" + email);
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Test
    void getCheckAllPhoneOnly(){
        try {
            List<users> u = emp.getuser();
            for (int i = 0; i < u.size();i++ ){
                String phone = u.get(i).getPhone();
                for (int j = i+1; j < u.size();j++){
                    Assertions.assertNotEquals(u.get(j).getPhone(),phone);
                    System.out.println(u.get(j).getPhone() + "##" + phone);
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Test
    void getCheckAllPhoneTrue(){
        try {
            List<users> u = emp.getuser();
            for (int i = 0; i < u.size();i++ ){
                Assertions.assertTrue(DataValidator.checkSDT(u.get(i).getPhone()));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Test
    void getCheckAllMailTrue(){
        try {
            List<users> u = emp.getuser();
            for (int i = 0; i < u.size();i++ ){
                Assertions.assertTrue(DataValidator.checkEmail(u.get(i).getEmail()));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}