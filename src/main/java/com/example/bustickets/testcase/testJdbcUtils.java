package com.example.bustickets.testcase;

import com.example.bustickets.config.JdbcUtils;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class testJdbcUtils {
    private static Connection cnn;
    @BeforeAll
    public static void beforeAll() throws SQLException {
        cnn = JdbcUtils.getCnn();
    }
    @AfterAll
    public static void afterAll() throws SQLException{
        if (cnn != null){
            cnn.close();
        }
    }
    @Test
    public void testUnique() throws SQLException{
        cnn = JdbcUtils.getCnn();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * from cars");
        List<String> kq = new ArrayList<>();
        while (rs.next()){
            String code_car = rs.getString("code_car");
            kq.add(code_car);
            System.out.println(code_car);
        }
        Set<String> kq2 = new HashSet<>(kq);
        Assertions.assertEquals(kq.size(),kq2.size());
    }
}
