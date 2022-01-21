package com.example.bustickets.services;

import com.example.bustickets.model.tickets;
import com.example.bustickets.model.users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class createticketsServicesTest {
    createticketsServices ctS = new createticketsServices();
    @Test
    void gettickets() {
        try {
            List<tickets> u = ctS.gettickets();
            for (int i = 0; i < u.size();i++ ){
                int Id = u.get(i).getIdtickets();
                for (int j = i+1; j < u.size();j++){
                    Assertions.assertNotEquals(u.get(j).getIdtickets(),Id);
                    System.out.println(u.get(j).getIdtickets() + "##" + Id);
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Test
    void checkLocationStart(){
        try {
            List<tickets> u = ctS.gettickets();
            for (int i = 0; i < u.size();i++ ){
                Assertions.assertEquals(u.get(i).getLocation_start(),"Hồ Chí Minh");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}