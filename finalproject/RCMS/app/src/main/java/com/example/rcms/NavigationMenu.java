package com.example.rcms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NavigationMenu extends AppCompatActivity {
    private Button tablesButton, ongoingOrdersButton, adminPanelButton;

    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_menu);

        tablesButton = findViewById(R.id.tablesbutton);
        ongoingOrdersButton = findViewById(R.id.ongoingordersbutton);
        adminPanelButton = findViewById(R.id.adminpanelbutton);

        tablesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NavigationMenu.this, Tables.class);
                startActivity(intent);
            }
        });

        ongoingOrdersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NavigationMenu.this, OngoingOrders.class);
                startActivity(intent);
            }
        });

        adminPanelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NavigationMenu.this, AdminPanel.class);
                startActivity(intent);
            }
        });
    }
}