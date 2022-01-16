package com.example.bustickets.testcase.com.example.bustickets.model;

import com.example.bustickets.model.users;
import com.example.bustickets.registerController;
import com.example.bustickets.services.DataValidator;
import com.example.bustickets.services.userServices;
import javafx.scene.control.Label;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.sql.SQLException;

public class RegisterTester {
    userServices u = new userServices();
    //Test chức năng kiểm tra định dạng email
    @Test
    public void TestValidateEmailByTrue(){
        String email = "botran@gmail.com";
        Assertions.assertTrue(DataValidator.checkEmail(email));
    }
    @Test
    public void TestValidateEmailByFalse() {
        String email = "botran.com";
        Assertions.assertFalse(DataValidator.checkEmail(email));
    }
    //Test chức năng kiểm tra định dạng số điện thoại
    @Test
    public void TestValidateNumberPhongByTrue(){
        String phone = "0123456789";
        Assertions.assertTrue(DataValidator.checkSDT(phone));
    }
    @Test
    public void TestValidateNumberPhongByFalse() {
        String phone = "088777444111";
        Assertions.assertFalse(DataValidator.checkSDT(phone));
    }
    //Test chức năng lấy id cuối cùng trong data
    @Test
    public void TestGetMaxIdUsers(){
        int id = u.getMaxIdUsers();
        Assertions.assertEquals(26,id);

    }
    //Test chức năng lấy thông tin user bằng id
    @Test
    public void TestGetUserById() throws SQLException {
        users user = u.getUserById(25);
        Assertions.assertEquals(user.getName(),"Trần Văn Bo");
    }
}
