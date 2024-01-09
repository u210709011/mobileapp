package com.example.rcms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends AppCompatActivity {

    private List<OrderItem> cartItems;
    private ShoppingCartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        cartItems = new ArrayList<>();
        cartItems.add(new OrderItem("Test Item 1", 5.99, "Test Category"));
        cartItems.add(new OrderItem("Test Item 2", 8.49, "Test Category"));
        cartItems.add(new OrderItem("Test Item 3", 12.99, "Test Category"));

        RecyclerView recyclerView = findViewById(R.id.listviewshoppingcart);
        cartAdapter = new ShoppingCartAdapter(cartItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cartAdapter);

        Button applyOrderButton = findViewById(R.id.shoppingcartok);
        applyOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyOrder();
            }
        });
    }

    private void applyOrder() {
        if (cartItems.isEmpty()) {
            return;
        }

        Intent ordersIntent = new Intent(ShoppingCart.this, Orders.class);
        ordersIntent.putParcelableArrayListExtra("orderedItems", new ArrayList<>(cartItems));

        startActivity(ordersIntent);

        cartItems.clear();
        cartAdapter.notifyDataSetChanged();
        finish();
    }
}
