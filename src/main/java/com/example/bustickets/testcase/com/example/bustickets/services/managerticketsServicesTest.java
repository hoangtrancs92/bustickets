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
            Assertions.assertEquals(c.get(0).getIddetail_tickets()  ,"05387658-35c0-4ca1-9410-72eeeacd0633");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}