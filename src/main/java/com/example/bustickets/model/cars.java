package com.example.bustickets.model;

public class cars {
    private int idcars;
    private String code_car;
    private int number_seat;

    public cars(){

    }
    public cars(int idcars, String code_car, int number_seat){
        this.idcars = idcars;
        this.code_car = code_car;
        this.number_seat = number_seat;
    }
    public int getIdcars() {
        return idcars;
    }

    public void setIdcars(int idcars) {
        this.idcars = idcars;
    }

    public String getCode_car() {
        return code_car;
    }

    public void setCode_car(String code_car) {
        this.code_car = code_car;
    }

    public int getNumber_seat() {
        return number_seat;
    }

    public void setNumber_seat(int number_seat) {
        this.number_seat = number_seat;
    }
}
