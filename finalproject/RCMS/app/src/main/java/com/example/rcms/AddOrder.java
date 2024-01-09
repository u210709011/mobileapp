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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class AddOrder extends AppCompatActivity implements AddOrderAdapter.ItemClickListener {

    private List<OrderItem> allMenuItems;
    private List<OrderItem> displayedMenuItems;
    private AddOrderAdapter addOrderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        RecyclerView recyclerView = findViewById(R.id.gridviewaddorder);

        allMenuItems = createSampleMenuItems();

        addOrderAdapter = new AddOrderAdapter(allMenuItems, this);
        recyclerView.setAdapter(addOrderAdapter);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        displayedMenuItems = new ArrayList<>(allMenuItems);

        Toolbar toolbar = findViewById(R.id.addordertoolbar);
        setSupportActionBar(toolbar);

        SearchView searchView = findViewById(R.id.addordersearch);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterMenuItems(newText);
                return true;
            }
        });

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

        buttonAllItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAllItemsButtonClick(v);
            }
        });

        Button buttonShoppingCart = findViewById(R.id.addordershoppingcartbutton);
        buttonShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddOrder.this, ShoppingCart.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private List<OrderItem> createSampleMenuItems() {
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem("Item 1", 10.99, "Appetizers"));
        items.add(new OrderItem("Item 2", 8.49, "Entrees"));
        items.add(new OrderItem("Item 3", 12.79, "Sides"));
        items.add(new OrderItem("Item 4", 7.99, "Desserts"));
        items.add(new OrderItem("Item 5", 2.99, "Beverages"));
        return items;
    }

    public void onCategoryButtonClick(View view) {
        String category = getCategoryFromButton(view);
        updateDisplayedMenuItems(category);
    }

    public void onAllItemsButtonClick(View view) {
        updateDisplayedMenuItems(null);
    }

    private String getCategoryFromButton(View view) {
        return ((Button) view).getText().toString();
    }

    private void updateDisplayedMenuItems(String category) {
        List<OrderItem> filteredItems = new ArrayList<>();
        for (OrderItem item : allMenuItems) {
            if (category == null || item.getOrderType().equals(category)) {
                filteredItems.add(item);
            }
        }

        displayedMenuItems = new ArrayList<>(filteredItems);
        addOrderAdapter.setMenuItems(displayedMenuItems);
    }

    private void filterMenuItems(String query) {
        List<OrderItem> filteredItems = new ArrayList<>();
        if (TextUtils.isEmpty(query)) {
            filteredItems.addAll(allMenuItems);
        } else {
            String lowerCaseQuery = query.toLowerCase();
            for (OrderItem item : allMenuItems) {
                if (item.getOrderName().toLowerCase().contains(lowerCaseQuery)) {
                    filteredItems.add(item);
                }
            }
        }

        displayedMenuItems = new ArrayList<>(filteredItems);
        addOrderAdapter.setMenuItems(displayedMenuItems);
    }

    @Override
    public void onItemClick(int position, OrderItem selectedItem) {
        Intent intent = new Intent(AddOrder.this, ItemInformation.class);
        intent.putExtra("itemName", selectedItem.getOrderName());
        intent.putExtra("itemPrice", selectedItem.getOrderPrice());
        intent.putExtra("itemType", selectedItem.getOrderType());
        startActivity(intent);
    }
}
