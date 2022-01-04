package com.example.bustickets.model;

public class finishing_points {
    private int id;
    private String finish;

    public finishing_points(String finish) {
        this.finish = finish;
    }

    public finishing_points(int id, String finish) {
        this.id = id;
        this.finish = finish;
    }

    @Override
    public String toString() {
        return finish ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }
}
