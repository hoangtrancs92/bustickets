package com.example.bustickets.model;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Date;
public class users {
    private int idusers;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    private int sex;
    private String birthday;

    //public users(TextField usernameField, PasswordField passwordField, TextField emailField, TextField phoneField, TextField addressField, DatePicker birthday, int sex) {}

    public users(int idusers, String name, String password,String email, String phone, String address, String birthday, int sex){
        this.idusers = idusers;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.sex = sex;
    }
    public users(String name, String password, String email, String phone, String address, String birthday, int sex){
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.sex = sex;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat(("dd/MM/yyyy"));
        return "users{" +
                "idusers=" + idusers +
                ", name='" + name + '-' +
                ", email='" + email + '-' +
                ", phone='" + phone + '-' +
                ", address='" + address + '-' +
                ", sex=" + sex +
                ", birthday=" + sdf.format(birthday) +
                '}';
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public int getIdusers() {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
