package com.example.rcms;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OngoingOrders extends AppCompatActivity {
    private RecyclerView recyclerViewOngoingOrders;
    private OngoingOrdersAdapter ongoingOrdersAdapter;
    private ArrayList<OrderItem> ongoingOrderItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongoing_orders);

        recyclerViewOngoingOrders = findViewById(R.id.recyclerviewongoingorders);
        recyclerViewOngoingOrders.setLayoutManager(new LinearLayoutManager(this));

        ongoingOrderItems = new ArrayList<>();

        ongoingOrderItems.add(new OrderItem("kadife tatlısı", 3.30, 2));
        ongoingOrderItems.add(new OrderItem("kerhane tatlısı", 1.30, 1));

        ongoingOrdersAdapter = new OngoingOrdersAdapter(this, ongoingOrderItems);

        recyclerViewOngoingOrders.setAdapter(ongoingOrdersAdapter);
    }
}
