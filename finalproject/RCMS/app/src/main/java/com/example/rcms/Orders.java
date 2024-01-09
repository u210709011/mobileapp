package com.example.rcms;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Orders extends AppCompatActivity {

    private RecyclerView recyclerViewOrders;
    private OrdersAdapter ordersAdapter;
    private ArrayList<OrderItem> orderItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        recyclerViewOrders = findViewById(R.id.recyclervieworders);
        recyclerViewOrders.setLayoutManager(new LinearLayoutManager(this));

        orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("çay", 5.10, 2));
        orderItems.add(new OrderItem("kadayıf", 30.14, 3));

        ordersAdapter = new OrdersAdapter(this, orderItems);

        recyclerViewOrders.setAdapter(ordersAdapter);

        Log.d("ORDERS", "Adapter was set");
    }
}
