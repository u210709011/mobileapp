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

        // Initialize the shopping cart and add some test items
        cartItems = new ArrayList<>();
        cartItems.add(new OrderItem("Test Item 1", 5.99, "Test Category"));
        cartItems.add(new OrderItem("Test Item 2", 8.49, "Test Category"));
        cartItems.add(new OrderItem("Test Item 3", 12.99, "Test Category"));

        // Initialize the RecyclerView and its adapter
        RecyclerView recyclerView = findViewById(R.id.listviewshoppingcart);
        cartAdapter = new ShoppingCartAdapter(cartItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cartAdapter);

        // Set onClickListener for the "Apply Order" button
        Button applyOrderButton = findViewById(R.id.shoppingcartok);
        applyOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement the logic to apply the order
                applyOrder();
            }
        });
    }

    private void applyOrder() {
        // Check if there are items in the shopping cart
        if (cartItems.isEmpty()) {
            // Display a message or take appropriate action if the cart is empty
            return;
        }

        // Create an Intent to pass the ordered items to the Orders class
        Intent ordersIntent = new Intent(ShoppingCart.this, Orders.class);
        ordersIntent.putParcelableArrayListExtra("orderedItems", new ArrayList<>(cartItems));

        // Start the Orders activity
        startActivity(ordersIntent);

        // Optionally, you can clear the shopping cart or perform any other cleanup
        cartItems.clear();
        cartAdapter.notifyDataSetChanged();
        // Finish the activity (you might want to navigate to another activity or perform other actions)
        finish();
    }
}
