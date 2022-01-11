package com.example.bustickets.model;

public class bookings extends detail_tickets {
    private int idbookings;
    private String code;
    private int status;
    private int users_id;
    private int seats_id;

    public bookings(){

    }
    public bookings(String code,int status, int users_id){
        this.code = code;
        this.status = status;
        this.users_id = users_id;
    }
    public bookings(int users_id){
        this.users_id = users_id;
    }

    public bookings(int idbookings, String code, int status, int users_id, int seats_id) {
        this.idbookings = idbookings;
        this.code = code;
        this.status = status;
        this.users_id = users_id;
        this.seats_id = seats_id;
    }

    public int getIdbookings() {
        return idbookings;
    }

    public void setIdbookings(int idbookings) {
        this.idbookings = idbookings;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getSeats_id() {
        return seats_id;
    }

    public void setSeats_id(int seats_id) {
        this.seats_id = seats_id;
    }
}
