package com.example.bustickets.model;

import java.util.Date;

public class tickets {
    private int idtickets;
    private String location_start;
    private String location_end;
    private int quanlity;
    private Date time_start;
    private String price;
    private int employees_id;

    public tickets(){

    }

    public tickets(int idtickets, String location_start, String location_end, int quanlity, Date time_start, String price, int employees_id) {
        this.idtickets = idtickets;
        this.location_start = location_start;
        this.location_end = location_end;
        this.quanlity = quanlity;
        this.time_start = time_start;
        this.price = price;
        this.employees_id = employees_id;
    }

    public Date getTime_start() {
        return time_start;
    }

    public void setTime_start(Date time_start) {
        this.time_start = time_start;
    }

    public int getIdtickets() {
        return idtickets;
    }

    public void setIdtickets(int idtickets) {
        this.idtickets = idtickets;
    }

    public String getLocation_start() {
        return location_start;
    }

    public void setLocation_start(String location_start) {
        this.location_start = location_start;
    }

    public String getLocation_end() {
        return location_end;
    }

    public void setLocation_end(String location_end) {
        this.location_end = location_end;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }



    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getEmployees_id() {
        return employees_id;
    }

    public void setEmployees_id(int employees_id) {
        this.employees_id = employees_id;
    }
}
