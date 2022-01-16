package com.example.bustickets.alerts;

public class totalMoney {
    private String name;

    private String phone;
    private int idbookings;
    private String iddetail_tickets;
    private int price;
    private String date_start;
    private String time_start;
    private String code_car;

    public totalMoney(String name, String phone, int idbookings, String iddetail_tickets, int price, String date_start, String time_start, String code_car){
        this.name = name;
        this.phone = phone;
        this.idbookings = idbookings;
        this.iddetail_tickets = iddetail_tickets;
        this.price = price;
        this.date_start = date_start;
        this.time_start = time_start;
        this.code_car = code_car;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIdbookings() {
        return idbookings;
    }

    public void setIdbookings(int idbookings) {
        this.idbookings = idbookings;
    }

    public String getIddetail_tickets() {
        return iddetail_tickets;
    }

    public void setIddetail_tickets(String iddetail_tickets) {
        this.iddetail_tickets = iddetail_tickets;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getCode_car() {
        return code_car;
    }

    public void setCode_car(String code_car) {
        this.code_car = code_car;
    }
}
