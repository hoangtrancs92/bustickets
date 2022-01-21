package com.example.bustickets.model;

import java.time.LocalDate;

public class tickets  extends cars{
    private int idtickets;
    private String code_seat;
    private int quanlity;
    private String price;
    private String name_employee;
    private String location_start;
    private String location_end;
    private String date_start;
    private String time_start;
    private String code_car;
    private int users_id;
    private int cars_id;
    private LocalDate time;
    // --- Constructor ---
    public  tickets(){

    }

    // create tickets --- create_tickets.fxml ---
    public tickets(int quanlity, String price, String name_employee, String location_start, String location_end, String date_start, String time_start, String code_car) {
        this.quanlity = quanlity;
        this.price = price;
        this.name_employee = name_employee;
        this.location_start = location_start;
        this.location_end = location_end;
        this.date_start = date_start;
        this.time_start = time_start;
        this.code_car = code_car;
    }

    // Take Id_TIckets --- create tickets controller ---
    public tickets(int idtickets) {

        this.idtickets = idtickets;
    }
    @Override
    public String toString() {
        return "tickets{" +
                "idtickets=" + idtickets +
                '}';
    }

    //Manager_tickets
    public tickets(String code_seat, int quanlity,String name_employee,String location_start,String location_end,String date_start,String time_start,String code_car) {
        this.code_seat = code_seat;
        this.quanlity = quanlity;
        this.name_employee = name_employee;
        this.location_start = location_start;
        this.location_end = location_end;
        this.date_start = date_start;
        this.time_start = time_start;
        this.code_car = code_car;
    }
    // Create_tickets
    public tickets(String location_start, String location_end,int quanlity, String date_start, String price, int users_id, String time_start, int cars_id){
        this.location_start = location_start;
        this.location_end = location_end;
        this.quanlity = quanlity;
        this.date_start = date_start;
        this.price = price;
        this.users_id = users_id;
        this.time_start = time_start;
        this.cars_id = cars_id;
    }
    // detail_tickets --- bookings_tickets.fxml ---

    public tickets(String time_start, String code_car) {
        this.time_start = time_start;
        this.code_car = code_car;
    }
    // detail_tickets 2 --- bookings_tickets.fxml ---

    public  tickets(String time_start, String code_car,String location_start,String location_end,String date_start,String price,int idtickets,int number_seat ){
        this.time_start = time_start;
        this.code_car = code_car;
        this.location_start = location_start;
        this.location_end = location_end;
        this.date_start = date_start;
        this.price = price;
        this.idtickets = idtickets;
        this.setNumber_seat(number_seat);
    }

    public tickets(int idtickets,int quanlity, String location_start ){
        this.idtickets = idtickets;
        this.quanlity = quanlity;
        this.location_start = location_start;
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
    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
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

    //Setter and getter employee_id

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    //Setter and getter cars_id
    public int getCars_id() {
        return cars_id;
    }

    public void setCars_id(int cars_id) {
        this.cars_id = cars_id;
    }

    //Setter and getter Price
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    //Setter and getter time
    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }
}
