package com.example.rcms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;

public class AddOrder extends AppCompatActivity {
    private int tableNumber; // Table number received from the previous activity

    private EditText searchView;
    private GridView menuGridView;
    private Button goToShoppingCartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        if (getIntent().hasExtra("TABLE_NUMBER")) {
            tableNumber = getIntent().getIntExtra("TABLE_NUMBER", 0);
        }

        searchView = findViewById(R.id.editTextSearch);
        menuGridView = findViewById(R.id.gridViewFoods);
        goToShoppingCartButton = findViewById(R.id.buttonOK);

        String[] menuItems = {"Item A", "Item B", "Item C", "Item D", "Item E", "Item F", "Item G", "Item H"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.grid_item_food, menuItems);

        menuGridView.setAdapter(adapter);

        menuGridView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = (String) parent.getItemAtPosition(position);
            // Add logic to handle adding the selected item to the shopping cart or orders
            // You might want to start another activity to manage the quantity, etc.
        });

        goToShoppingCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shoppingCartIntent = new Intent(AddOrder.this, ShoppingCart.class);
                shoppingCartIntent.putExtra("TABLE_NUMBER", tableNumber);
                startActivity(shoppingCartIntent);
            }
        });
    }
}
