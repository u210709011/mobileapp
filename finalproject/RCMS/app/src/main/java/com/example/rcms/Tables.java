package com.example.rcms;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Tables extends AppCompatActivity {
    private Button table1Button, table2Button, table3Button,table4Button, table5Button, table6Button,table7Button, table8Button, table9Button,table10Button, table11Button, table12Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        Log.d("Tables:", "table is on");
        table1Button = findViewById(R.id.button1);
        table2Button = findViewById(R.id.button2);
        table3Button = findViewById(R.id.button3);
        table4Button = findViewById(R.id.button4);
        table5Button = findViewById(R.id.button5);
        table6Button = findViewById(R.id.button6);
        table7Button = findViewById(R.id.button7);
        table8Button = findViewById(R.id.button8);
        table9Button = findViewById(R.id.button9);
        table10Button = findViewById(R.id.button10);
        table11Button = findViewById(R.id.button11);
        table12Button = findViewById(R.id.button12);



        table1Button.setOnClickListener(view -> navigateToCustomerTable(1));

        table2Button.setOnClickListener(view -> navigateToCustomerTable(2));

        table3Button.setOnClickListener(view -> navigateToCustomerTable(3));

        table4Button.setOnClickListener(view -> navigateToCustomerTable(4));

        table5Button.setOnClickListener(view -> navigateToCustomerTable(5));

        table6Button.setOnClickListener(view -> navigateToCustomerTable(6));

        table7Button.setOnClickListener(view -> navigateToCustomerTable(7));

        table8Button.setOnClickListener(view -> navigateToCustomerTable(8));

        table9Button.setOnClickListener(view -> navigateToCustomerTable(9));

        table10Button.setOnClickListener(view -> navigateToCustomerTable(10));

        table11Button.setOnClickListener(view -> navigateToCustomerTable(11));

        table12Button.setOnClickListener(view -> navigateToCustomerTable(12));

    }

    private void navigateToCustomerTable(int tableNumber) {
        Intent intent = new Intent(Tables.this, CustomerTable.class);

        intent.putExtra("TABLE_NUMBER", tableNumber);

        startActivity(intent);
    }
}
