package com.example.bustickets.model;

public class stores {
    private int idstores;
    private String name;

    public stores(){

    }
    public stores(int idstores,String name){
        this.idstores = idstores;
        this.name = name;
    }
    public int getIdstores() {
        return idstores;
    }

    public void setIdstores(int idstores) {
        this.idstores = idstores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
