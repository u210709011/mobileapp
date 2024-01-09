package com.example.rcms;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class OrderItem implements Parcelable{

    private String orderName;
    private double orderPrice;
    private int orderQuantity;
    private String orderType;

    protected OrderItem(Parcel in) {
        orderName = in.readString();
        orderPrice = in.readDouble();
        orderType = in.readString();
        orderQuantity = in.readInt();
    }

    public static final Creator<OrderItem> CREATOR = new Creator<OrderItem>() {
        @Override
        public OrderItem createFromParcel(Parcel in) {
            return new OrderItem(in);
        }

        @Override
        public OrderItem[] newArray(int size) {
            return new OrderItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(orderName);
        dest.writeDouble(orderPrice);
        dest.writeString(orderType);
        dest.writeInt(orderQuantity);
    }


    public OrderItem() {
    }

    public OrderItem(String orderName, double orderPrice) {
        this.orderName = orderName;
        this.orderPrice = orderPrice;
    }

    public OrderItem(String orderName, double orderPrice, String orderType) {
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.orderType = orderType;
    }

    public OrderItem(String orderName, double orderPrice, int orderQuantity) {
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.orderQuantity = orderQuantity;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
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

    public void incrementQuantity() {
        orderQuantity++;
    }

    public void decrementQuantity() {
        if (orderQuantity > 1) {
            orderQuantity--;
        }
    }
}
