package com.example.bustickets.testcase.com.example.bustickets.model;

import com.example.bustickets.model.starting_points;
import com.example.bustickets.services.startServices;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.SQLException;
import java.util.List;

public class StartTest {
    startServices start = new startServices();
    //Kiểm tra dữ liệu lấy từ MySQL
    @Test
    public void TestGetPoint() throws SQLException {
        List<starting_points> st = start.getPoint();
        Assertions.assertEquals(st.get(0).getStart(),"Hồ Chí Minh");
    }
}
