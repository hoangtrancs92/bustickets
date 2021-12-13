package com.example.bustickets.model;

public class seats {
    private int idseats;
    private String code;
    private int status;
    private int cars_id;
    private int tickets_id;

    public seats(){

    }

    public seats(int idseats, String code, int status, int cars_id, int tickets_id) {
        this.idseats = idseats;
        this.code = code;
        this.status = status;
        this.cars_id = cars_id;
        this.tickets_id = tickets_id;
    }

    public int getIdseats() {
        return idseats;
    }

    public void setIdseats(int idseats) {
        this.idseats = idseats;
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

    public int getCars_id() {
        return cars_id;
    }

    public void setCars_id(int cars_id) {
        this.cars_id = cars_id;
    }

    public int getTickets_id() {
        return tickets_id;
    }

    public void setTickets_id(int tickets_id) {
        this.tickets_id = tickets_id;
    }
}
