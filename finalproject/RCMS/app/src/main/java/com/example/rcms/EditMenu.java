package com.example.rcms;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class EditMenu extends AppCompatActivity implements EditMenuAdapter.OnItemClickListener {

    private EditMenuAdapter editMenuAdapter;
    private List<OrderItem> allMenuItems;
    private List<OrderItem> displayedMenuItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_menu);

        RecyclerView recyclerView = findViewById(R.id.editmenurecyclerview);
        allMenuItems = createSampleMenuItems();
        editMenuAdapter = new EditMenuAdapter(allMenuItems, this,this);
        recyclerView.setAdapter(editMenuAdapter);
        editMenuAdapter.setGridLayout(recyclerView, 2);
        displayedMenuItems = new ArrayList<>(allMenuItems);

        Button buttonDesserts = findViewById(R.id.editmenudesserts);
        Button buttonSides = findViewById(R.id.editmenusides);
        Button buttonBeverages = findViewById(R.id.editmenubeverages);
        Button buttonAppetizers = findViewById(R.id.editmenuappetizers);
        Button buttonEntrees = findViewById(R.id.editmenuentrees);
        Button buttonAllItems = findViewById(R.id.editmenuallitems);
        Button buttonAddItem = findViewById(R.id.editmenuadditem);

        buttonDesserts.setOnClickListener(new View.OnClickListener() {
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
        buttonBeverages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCategoryButtonClick(v);
            }
        });
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

        buttonAllItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAllItemsButtonClick(v);
            }
        });

        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditMenu.this, AddItem.class);
                startActivity(intent);
            }
        });

        Toolbar toolbar = findViewById(R.id.editmenutoolbar);
        setSupportActionBar(toolbar);

        SearchView searchView = findViewById(R.id.editmenusearch);
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
        editMenuAdapter.setMenuItems(displayedMenuItems);
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
        editMenuAdapter.setMenuItems(displayedMenuItems);
    }

    @Override
    public void onItemClick(OrderItem item) {
        Intent intent = new Intent(EditMenu.this, ItemInformation.class);
        intent.putExtra("itemName", item.getOrderName());
        intent.putExtra("itemPrice", item.getOrderPrice());
        startActivity(intent);
    }
}
