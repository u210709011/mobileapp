package com.example.rcms;

import android.graphics.Bitmap;
import android.widget.Spinner;

public class Employee {

    private String name;
    private String ID;
    private String birthday;
    private String password;
    private String sex;
    private String address;
    private int hoursWorked;

    public Employee() {
    }

    public Employee(String name, String ID, String password, String sex, String birthday, String address, int hoursWorked) {
        this.name = name;
        this.ID = ID;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.hoursWorked = hoursWorked;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passsword) {
        this.password = passsword;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
