package com.example.rcms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        TextView name = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dummyUserId = "user123";
                String dummyPassword = "pass123";

                String enteredUserId = name.getText().toString();
                String enteredPassword = password.getText().toString();
                Intent intent = new Intent(LoginScreen.this, NavigationMenu.class);
                startActivity(intent);
            }
        });




    }
}