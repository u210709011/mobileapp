package com.example.rcms;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Tables extends AppCompatActivity {
    private Button table1Button, table2Button, table3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        Log.d("Tables:", "table is on");
        table1Button = findViewById(R.id.button4);
        table2Button = findViewById(R.id.button5);
        table3Button = findViewById(R.id.button6);

        table1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToCustomerTable(1);
            }
        });

        table2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToCustomerTable(2);
            }
        });

        table3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToCustomerTable(3);
            }
        });
    }

    private void navigateToCustomerTable(int tableNumber) {
        // Create an intent to navigate to the CustomerTable activity
        Intent intent = new Intent(Tables.this, CustomerTable.class);

        // Pass the table number to the next activity
        intent.putExtra("TABLE_NUMBER", tableNumber);

        // Start the activity
        startActivity(intent);
    }
}
