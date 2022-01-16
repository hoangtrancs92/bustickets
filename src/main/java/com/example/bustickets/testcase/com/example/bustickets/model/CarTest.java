package com.example.bustickets.model;

import com.example.bustickets.model.cars;
import com.example.bustickets.services.carServices;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.SQLException;
import java.util.List;

public class CarTest {
    carServices carSer = new carServices();
    //Kiểm tra dữ liệu lấy từ MySQL
    @Test
    public void TestGetCar(){
        try {
            List<cars> c = carSer.getCars();
            Assertions.assertEquals(c.get(0).getCode_car(),"59OU001");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
