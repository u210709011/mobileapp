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

public class EditMenu extends AppCompatActivity {
    private EditText searchView;
    private GridView menuGridView;
    private Button addItemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_menu);

        searchView = findViewById(R.id.editMenuSearch);
        menuGridView = findViewById(R.id.editmenugridview);
        addItemButton = findViewById(R.id.editmenuadditem);

        String[] menuItems = {"Item A", "Item B", "Item C", "Item D", "Item E", "Item F", "Item G", "Item H"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.grid_item_editmenu, menuItems);

        menuGridView.setAdapter(adapter);

        menuGridView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = (String) parent.getItemAtPosition(position);
            // Add logic to handle clicking on a menu item (if needed)
        });

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addItemIntent = new Intent(EditMenu.this, AddItem.class);
                startActivity(addItemIntent);
            }
        });
    }
}
