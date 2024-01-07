package com.example.rcms;

import android.graphics.Bitmap;

public class OrderItem {

    private String orderName;
    private double orderPrice;
    private int orderQuantity;

    public OrderItem(String orderName, double orderPrice, int orderQuantity) {
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.orderQuantity = orderQuantity;
    }


    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
}
