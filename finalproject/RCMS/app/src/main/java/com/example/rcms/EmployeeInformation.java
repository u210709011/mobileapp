package com.example.rcms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EmployeeInformation extends AppCompatActivity {
    private ImageView employeeImageView;
    private TextView nameTextView, idTextView, passwordTextView, birthdayTextView, addressTextView;
    private Spinner sexSpinner;
    private Button deleteEmployeeButton, saveEmployeeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_information);

        employeeImageView = findViewById(R.id.employeeinformationimage);
        nameTextView = findViewById(R.id.employeeinformationname);
        idTextView = findViewById(R.id.employeeinformationid);
        passwordTextView = findViewById(R.id.employeeinformationpassword);
        birthdayTextView = findViewById(R.id.employeeinformationbirthday);
        addressTextView = findViewById(R.id.employeeinformationaddress);
        sexSpinner = findViewById(R.id.employeeinformationsex);
        deleteEmployeeButton = findViewById(R.id.deleteemployee);
        saveEmployeeButton = findViewById(R.id.saveemployee);

        // Dummy data for demonstration, replace with actual data from your database
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("EMPLOYEE_NAME")) {
            String selectedEmployee = intent.getStringExtra("EMPLOYEE_NAME");

            nameTextView.setText(selectedEmployee);
            idTextView.setText("EmployeeID123");  // Replace with actual ID
            passwordTextView.setText("********");  // Replace with actual password
            birthdayTextView.setText("01/01/1990");  // Replace with actual birthday
            addressTextView.setText("123 Main St, City");  // Replace with actual address

            // Set a click listener for the "Delete Employee" button
            deleteEmployeeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Add logic to delete the employee (implement as needed)
                    // For simplicity, just go back to the EditEmployee activity
                    finish();
                }
            });

            saveEmployeeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Add logic to save the changes made to the employee information (implement as needed)
                    // For simplicity, just go back to the EditEmployee activity
                    finish();
                }
            });
        }
    }
}
