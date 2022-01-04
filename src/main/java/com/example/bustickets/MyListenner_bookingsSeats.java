package com.example.bustickets;

import com.example.bustickets.model.detail_tickets;

import java.io.IOException;
import java.util.ArrayList;

public interface MyListenner_bookingsSeats {
    public ArrayList<String> onClickListener_bookingsSeats(detail_tickets detailTickets) throws IOException;
}
