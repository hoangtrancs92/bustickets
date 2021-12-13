package com.example.bustickets.model;

public class employees {
    private int idemployees;
    private String name;
    private String email;
    private String password;
    private int stores_id;

    public employees(){

    }

    public employees(int idemployees,String name, String email, String password, int stores_id){
        this.idemployees = idemployees;
        this.name = name;
        this.email = email;
        this.password = password;
        this.stores_id = stores_id;
    }

    public int getIdemployees() {
        return idemployees;
    }

    public void setIdemployees(int idemployees) {
        this.idemployees = idemployees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStores_id() {
        return stores_id;
    }

    public void setStores_id(int stores_id) {
        this.stores_id = stores_id;
    }
}
