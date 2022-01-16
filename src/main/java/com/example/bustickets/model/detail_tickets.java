package com.example.bustickets.model;

public class detail_tickets extends tickets {
    private String iddetail_tickets;
    private int id_tickets;
    private int id_bookings;
    // Constructor

    public detail_tickets(String iddetail_tickets, int id_tickets, int id_bookings) {
        this.iddetail_tickets = iddetail_tickets;
        this.id_tickets = id_tickets;
        this.id_bookings = id_bookings;
    }

    public detail_tickets(String iddetail_tickets, int id_bookings) {
        this.iddetail_tickets = iddetail_tickets;
        this.id_tickets = id_bookings;
    }
    public detail_tickets(String iddetail_tickets) {
        this.iddetail_tickets = iddetail_tickets;

    }
    public detail_tickets() {

    }

    // Constructor
    public String getIddetail_tickets() {
        return iddetail_tickets;
    }

    public void setIddetail_tickets(String iddetail_tickets) {
        this.iddetail_tickets = iddetail_tickets;
    }

    public int getId_tickets() {
        return id_tickets;
    }

    public void setId_tickets(int id_tickets) {
        this.id_tickets = id_tickets;
    }

    public int getId_bookings() {
        return id_bookings;
    }

    public void setId_bookings(int id_bookings) {
        this.id_bookings = id_bookings;
    }
}


