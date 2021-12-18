package com.example.bustickets.model;

import java.util.Date;

public class tickets {
    private int idtickets;
    private String code_seat;
    private int quanlity;
    private String name_employee;
    private String location_start;
    private String location_end;
    private Date date_start;
    private String time_start;
    private String code_car;

    // --- Constructor ---
    public  tickets(){

    }

    public tickets(String code_seat, int quanlity,String name_employee,String location_start,String location_end,Date date_start,String time_start,String code_car) {
        this.code_seat = code_seat;
        this.quanlity = quanlity;
        this.name_employee = name_employee;
        this.location_start = location_start;
        this.location_end = location_end;
        this.date_start = date_start;
        this.time_start = time_start;
        this.code_car = code_car;
    }

    // --- Constructor ---

    //Setter and getter name_employee

    public String getName_employee() {
        return name_employee;
    }
    public void setName_employee(String name_employee) {
        this.name_employee = name_employee;
    }

    //Setter and getter location_start

    public String getLocation_start() {
        return location_start;
    }
    public void setLocation_start(String location_start) {
        this.location_start = location_start;
    }

    //Setter and getter location_end
    public String getLocation_end() {
        return location_end;
    }

    public void setLocation_end(String location_end) {
        this.location_end = location_end;
    }

    //Setter and getter date_start
    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    //Setter and getter time_start
    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    //Setter and getter getcode_car
    public String getCode_car() {
        return code_car;
    }

    public void setCode_car(String code_car) {
        this.code_car = code_car;
    }


    //Setter and getter idtickets
    public int getIdtickets() {
        return idtickets;
    }

    public void setIdtickets(int idtickets) {
        this.idtickets = idtickets;
    }

    //Setter and getter code_seat
    public String getCode_seat() {
        return code_seat;
    }

    public void setCode_seat(String code_seat) {
        this.code_seat = code_seat;
    }

    //Setter and getter quanlity
    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }
}
