package com.example.rcms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AdminPanel extends AppCompatActivity {
    private Button editEmployeeButton, editMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        editEmployeeButton = findViewById(R.id.editemployee);
        editMenuButton = findViewById(R.id.editmenu);

        editEmployeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminPanel.this, EditEmployee.class);
                startActivity(intent);
            }
        });

        editMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminPanel.this, EditMenu.class);
                startActivity(intent);
            }
        });
    }
}
