package com.example.bustickets.model;
import java.text.SimpleDateFormat;
import java.util.Date;
public class users {
    private int idusers;
    private String name;
    private String email;
    private String phone;
    private String address;
    private int sex;
    private Date birthday;

    public int getIdusers() {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
