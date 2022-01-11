package com.example.bustickets.testcase.com.example.bustickets.model;

import com.example.bustickets.model.time;
import com.example.bustickets.services.timeServices;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class TimeTester {
    timeServices s = new timeServices();
    //Kiểm tra dữ liệu lấy từ MySQL
    @Test
    public void TestGetTime() throws SQLException {
        List<time> t = s.getTime();
        Assertions.assertEquals(t.get(0).toString(),"07:30");

    }
}
