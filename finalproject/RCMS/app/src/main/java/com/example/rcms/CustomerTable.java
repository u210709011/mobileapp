package com.example.rcms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CustomerTable extends AppCompatActivity {
    private int tableNumber;

    private TextView tableNumberTextView, tableStatusTextView, addOrderButton, viewOrdersButton;
    private Button  settleBillButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_table);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("TABLE_NUMBER")) {
            tableNumber = intent.getIntExtra("TABLE_NUMBER", 0);
        }

        tableNumberTextView = findViewById(R.id.tableno);
        tableStatusTextView = findViewById(R.id.status);
        viewOrdersButton = findViewById(R.id.orders);
        addOrderButton = findViewById(R.id.addorder);
        settleBillButton = findViewById(R.id.settle);

        tableNumberTextView.setText("Table Number: " + tableNumber);
        tableStatusTextView.setText("Status: Occupied");

        viewOrdersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordersIntent = new Intent(CustomerTable.this, Orders.class);
                ordersIntent.putExtra("TABLE_NUMBER", tableNumber);
                startActivity(ordersIntent);
            }
        });

        addOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addOrderIntent = new Intent(CustomerTable.this, AddOrder.class);
                addOrderIntent.putExtra("TABLE_NUMBER", tableNumber);
                startActivity(addOrderIntent);
            }
        });

        settleBillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
