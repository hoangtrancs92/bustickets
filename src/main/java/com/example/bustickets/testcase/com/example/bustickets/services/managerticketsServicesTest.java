package com.example.bustickets.services;

import com.example.bustickets.model.cars;
import com.example.bustickets.model.detail_tickets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class managerticketsServicesTest {

    private  static  managerticketsServices mngS = new  managerticketsServices();
    @Test
    public void testID() {
        try {
            List<detail_tickets> c = mngS.getId();
            Assertions.assertEquals(c.get(0).getIddetail_tickets()  ,"01f780ab-ed26-4303-a1f2-93a55c21f38c");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}