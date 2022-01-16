package com.example.bustickets.testcase.com.example.bustickets.model;

import com.example.bustickets.model.finishing_points;
import com.example.bustickets.services.finishServices;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;
public class finishTest {
    finishServices finishServices = new finishServices();
    //Kiểm tra dữ liệu lấy từ MySQL
    @Test
    public void TestGetFinishPoints() throws Exception {
        List<finishing_points> fn = finishServices.getPointEnd();
        Assertions.assertEquals(fn.get(0).getFinish(),"Nha Trang");
    }
}
