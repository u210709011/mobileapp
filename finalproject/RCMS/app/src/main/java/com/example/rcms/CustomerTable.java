package com.example.rcms;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CustomerTable extends AppCompatActivity {
    private Table table;

    private TextView addOrderButton, viewOrdersButton, tableBill, tableNumberTextView, tableStatusTextView;
    private Button settleBillButton;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_table);

        tableBill = findViewById(R.id.ttlcsttxt);
        tableNumberTextView = findViewById(R.id.tableno);
        tableStatusTextView = findViewById(R.id.status);
        viewOrdersButton = findViewById(R.id.orders);
        addOrderButton = findViewById(R.id.addorder);
        settleBillButton = findViewById(R.id.settle);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("TABLE_OBJECT")) {
            table = (Table) intent.getSerializableExtra("TABLE_OBJECT");
            if (table != null) {
                // Proceed with using the table object
                tableBill.setText("Total Cost: " + table.getTotalCost());
            } else {
                // Log or handle the case where the table object is null
            }
        }




        // Set values to TextViews
        tableBill.setText("Total Cost: " + table.getTotalCost());
        tableNumberTextView.setText("Table Number: " + table.getTableno());
        tableStatusTextView.setText("Status: " + (table.getStatus() ? "Occupied" : "Empty"));

        viewOrdersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordersIntent = new Intent(CustomerTable.this, Orders.class);
                ordersIntent.putExtra("TABLE_NUMBER", table.getTableno());
                startActivity(ordersIntent);
            }
        });

        addOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addOrderIntent = new Intent(CustomerTable.this, AddOrder.class);
                addOrderIntent.putExtra("TABLE_NUMBER", table.getTableno());
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
