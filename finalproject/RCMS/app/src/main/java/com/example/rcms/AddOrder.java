package com.example.rcms;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class AddOrder extends AppCompatActivity {

    private List<OrderItem> allMenuItems;
    private List<OrderItem> displayedMenuItems;
    private EditMenuAdapter addOrderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        // Initialize your RecyclerView
        RecyclerView recyclerView = findViewById(R.id.gridviewaddorder);

        // Create sample menu items (replace this with your actual data)
        allMenuItems = createSampleMenuItems();

        // Initialize and set up the EditMenuAdapter with all menu items initially
        addOrderAdapter = new EditMenuAdapter(allMenuItems, this);
        recyclerView.setAdapter(addOrderAdapter);

        // Set the grid layout with the desired number of columns
        addOrderAdapter.setGridLayout(recyclerView, 2); // 2 columns in this example

        // Initially, display all menu items
        displayedMenuItems = new ArrayList<>(allMenuItems);

        // Setup Toolbar with SearchView
        Toolbar toolbar = findViewById(R.id.addordertoolbar);
        setSupportActionBar(toolbar);

        // Setup SearchView
        SearchView searchView = findViewById(R.id.addordersearch);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter displayed menu items based on search query
                filterMenuItems(newText);
                return true;
            }
        });

        // Set onClick listeners for category buttons
        Button buttonAppetizers = findViewById(R.id.addorderappetizers);
        Button buttonEntrees = findViewById(R.id.addorderentrees);
        Button buttonSides = findViewById(R.id.addordersides);
        Button buttonDesserts = findViewById(R.id.addorderdesserts);
        Button buttonBeverages = findViewById(R.id.addorderbeverages);
        Button buttonAllItems = findViewById(R.id.addorderallitems);

        buttonAppetizers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCategoryButtonClick(v);
            }
        });

        buttonEntrees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCategoryButtonClick(v);
            }
        });

        buttonSides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCategoryButtonClick(v);
            }
        });

        buttonDesserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCategoryButtonClick(v);
            }
        });

        buttonBeverages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCategoryButtonClick(v);
            }
        });

        // Set onClick listener for "All Items" button
        buttonAllItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAllItemsButtonClick(v);
            }
        });

        // Set onClick listener for shopping cart button
        Button buttonShoppingCart = findViewById(R.id.addordershoppingcartbutton);
        buttonShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to ShoppingCart class
                startActivity(new Intent(AddOrder.this, ShoppingCart.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle other menu item clicks if needed
        return super.onOptionsItemSelected(item);
    }

    // Method to create sample menu items (replace this with your actual data)
    private List<OrderItem> createSampleMenuItems() {
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem("Item 1", 10.99, "Appetizers"));
        items.add(new OrderItem("Item 2", 8.49, "Entrees"));
        items.add(new OrderItem("Item 3", 12.79, "Sides"));
        items.add(new OrderItem("Item 4", 7.99, "Desserts"));
        items.add(new OrderItem("Item 5", 2.99, "Beverages"));
        // Add more items as needed
        return items;
    }

    // Handle category button clicks
    public void onCategoryButtonClick(View view) {
        String category = getCategoryFromButton(view);
        updateDisplayedMenuItems(category);
    }

    // Handle "All Items" button click
    public void onAllItemsButtonClick(View view) {
        // Display all menu items
        updateDisplayedMenuItems(null);
    }

    // Helper method to get category from button text
    private String getCategoryFromButton(View view) {
        // You may need to adapt this based on your button text format
        return ((Button) view).getText().toString();
    }

    // Update displayed menu items based on the selected category
    private void updateDisplayedMenuItems(String category) {
        List<OrderItem> filteredItems = new ArrayList<>();
        for (OrderItem item : allMenuItems) {
            if (category == null || item.getOrderType().equals(category)) {
                filteredItems.add(item);
            }
        }

        // Update displayed menu items and notify the adapter
        displayedMenuItems = new ArrayList<>(filteredItems);
        addOrderAdapter.setMenuItems(displayedMenuItems);
    }

    // Filter displayed menu items based on search query
    private void filterMenuItems(String query) {
        List<OrderItem> filteredItems = new ArrayList<>();
        if (TextUtils.isEmpty(query)) {
            // If the query is empty, display all menu items
            filteredItems.addAll(allMenuItems);
        } else {
            // Filter items based on the search query (case-insensitive)
            String lowerCaseQuery = query.toLowerCase();
            for (OrderItem item : allMenuItems) {
                if (item.getOrderName().toLowerCase().contains(lowerCaseQuery)) {
                    filteredItems.add(item);
                }
            }
        }

        // Update displayed menu items and notify the adapter
        displayedMenuItems = new ArrayList<>(filteredItems);
        addOrderAdapter.setMenuItems(displayedMenuItems);
    }
}
