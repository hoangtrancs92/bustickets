package com.example.bustickets.services;

import com.example.bustickets.model.bookings;
import com.example.bustickets.model.users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class bookingsServicesTest {

    bookingsServices bkS = new  bookingsServices();
    @Test
    void getbooking() {
        try {
            List<bookings> u = bkS.getbooking();
            for (int i = 0; i < u.size();i++ ){
                int idbookings = u.get(i).getIdbookings();
                for (int j = i+1; j < u.size();j++){
                    Assertions.assertNotEquals(u.get(j).getIdbookings(),idbookings);
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}