package com.example.bustickets.model;

public class starting_points {
    private int id;
    private String start;

    public starting_points(String start) {
        this.start = start;
    }

    public starting_points(int id, String start) {
        this.id = id;
        this.start = start;
    }

    @Override
    public String toString() {
        return start;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

}
