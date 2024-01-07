package com.example.rcms;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class ShoppingCart extends AppCompatActivity {
    private int tableNumber; // Table number received from the previous activity

    private ListView cartListView;
    private Button applyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        if (getIntent().hasExtra("TABLE_NUMBER")) {
            tableNumber = getIntent().getIntExtra("TABLE_NUMBER", 0);
        }

        cartListView = findViewById(R.id.listviewshoppingcart);
        applyButton = findViewById(R.id.shoppingcartok);

        String[] cartItems = {"Item A - $10.00 - Quantity: 2", "Item B - $15.00 - Quantity: 1"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cartItems);

        cartListView.setAdapter(adapter);

        cartListView.setOnItemClickListener((parent, view, position, id) -> {
            // Add logic to handle item selection in the cart (if needed)
        });

        // Set a click listener for the "Apply" button
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add logic to apply the changes in the shopping cart
                // For simplicity, you can go back to the AddOrder activity
                finish();
            }
        });
    }
}
