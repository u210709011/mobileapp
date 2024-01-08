package com.example.rcms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class AddItem extends AppCompatActivity {

    private EditText itemNameEditText;
    private EditText itemPriceEditText;
    private Spinner itemTypeSpinner;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        itemNameEditText = findViewById(R.id.additemnameinput);
        itemPriceEditText = findViewById(R.id.additemprice);
        itemTypeSpinner = findViewById(R.id.additemtype);
        addButton = findViewById(R.id.additemaddbutton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.item_types,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemTypeSpinner.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
    }

    private void addItem() {
        String itemName = itemNameEditText.getText().toString();
        String itemPriceText = itemPriceEditText.getText().toString();
        String itemType = itemTypeSpinner.getSelectedItem().toString();

        if (itemName.isEmpty() || itemPriceText.isEmpty()) {
            return;
        }

        double itemPrice = Double.parseDouble(itemPriceText);

        OrderItem newItem = new OrderItem(itemName, itemPrice, itemType);

        finish();
    }
}
