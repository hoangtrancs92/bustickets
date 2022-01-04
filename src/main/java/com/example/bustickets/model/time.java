package com.example.bustickets.model;

public class time {
    private int id;
    private String time;

    @Override
    public String toString() {
        return time ;
    }

    public time(String time) {
        this.time = time;
    }

    public time(int id, String time) {
        this.id = id;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
