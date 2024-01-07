package com.example.rcms;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ItemInformation extends AppCompatActivity {
    private ImageView itemImageView;
    private TextView itemNameTextView, itemPriceTextView;
    private Spinner itemTypeSpinner;
    private Button deleteItemButton, saveItemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_information);

        itemImageView = findViewById(R.id.iteminfoimage);
        itemNameTextView = findViewById(R.id.iteminfonameinput);
        itemPriceTextView = findViewById(R.id.iteminfoprice);
        itemTypeSpinner = findViewById(R.id.iteminfotype);
        deleteItemButton = findViewById(R.id.iteminfodeleteitem);
        saveItemButton = findViewById(R.id.iteminfoadditem);

        // Dummy data for demonstration, replace with actual data from your database
        String itemName = "Item A";
        String itemPrice = "$10.00";

        // Display the information of the selected menu item
        itemNameTextView.setText(itemName);
        itemPriceTextView.setText(itemPrice);

        // Set a click listener for the "Delete Item" button
        deleteItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add logic to delete the item (implement as needed)
                // For simplicity, just go back to the EditMenu activity
                finish();
            }
        });

        // Set a click listener for the "Save Item" button
        saveItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add logic to save the changes made to the menu item (implement as needed)
                // For simplicity, just go back to the EditMenu activity
                finish();
            }
        });
    }
}
