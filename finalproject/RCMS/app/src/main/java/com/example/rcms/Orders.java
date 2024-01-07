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
    private ArrayList<OrderItem> orderItems; // Provide your data here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        recyclerViewOrders = findViewById(R.id.recyclervieworders);
        recyclerViewOrders.setLayoutManager(new LinearLayoutManager(this));

        // Initialize orderItems with appropriate data
        orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("çay", 5.10, 2));
        orderItems.add(new OrderItem("kadayıf", 30.14, 3));
        // Add more OrderItem objects as needed

        // Create an instance of OrdersAdapter
        ordersAdapter = new OrdersAdapter(this, orderItems);

        // Set the OrdersAdapter as the adapter for the RecyclerView
        recyclerViewOrders.setAdapter(ordersAdapter);

        Log.d("ORDERS", "Adapter was set");
    }
}
