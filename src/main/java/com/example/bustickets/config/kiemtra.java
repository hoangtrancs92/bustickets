package com.example.bustickets.config;

public class kiemtra {
    public String name;

    public kiemtra(String name) {
        this.name = name;
    }
    public String hello(){
        return  "hello" + name;
    }
    public  String hello(String other){
        return  "hello" + other;
    }
}
