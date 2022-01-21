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
    @Test
    public void TestSeatCar1(){
        try {
            List<cars> c = carSer.getCars();
            Assertions.assertEquals(c.get(0).getNumber_seat(),16);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void TestSeatCar2(){
        try {
            List<cars> c = carSer.getCars();
            Assertions.assertEquals(c.get(1).getNumber_seat(),20);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void TestSeatCar3(){
        try {
            List<cars> c = carSer.getCars();
            Assertions.assertEquals(c.get(2).getNumber_seat(),24);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
