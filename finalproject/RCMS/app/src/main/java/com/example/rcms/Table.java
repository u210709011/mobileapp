package com.example.rcms;

import java.io.Serializable;
import java.util.ArrayList;

public class Table implements Serializable {
    private int tableno;
    private double totalCost;
    private ArrayList<OrderItem> orders;
    private boolean status; //0 empty, 1 full

    public Table() {
    }

    public Table(int tableno, double totalCost, ArrayList<OrderItem> orders, boolean status) {
        this.tableno = tableno;
        this.totalCost = totalCost;
        this.orders = orders;
        this.status = status;
    }

    public int getTableno() {
        return tableno;
    }

    public void setTableno(int tableno) {
        this.tableno = tableno;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public ArrayList<OrderItem> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<OrderItem> orders) {
        this.orders = orders;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
