package com.example.rcms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EmployeeInformation extends AppCompatActivity {
    private EditText employeeNameEditText;
    private EditText employeeIDEditText;
    private EditText employeePasswordEditText;
    private Spinner employeeSexSpinner;
    private EditText employeeBirthdayEditText;
    private EditText employeeAddressEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_information);

        employeeNameEditText = findViewById(R.id.employeeinformationname);
        employeeIDEditText = findViewById(R.id.employeeinformationid);
        employeePasswordEditText = findViewById(R.id.employeeinformationpassword);
        employeeSexSpinner = findViewById(R.id.employeeinformationsex);
        employeeBirthdayEditText = findViewById(R.id.employeeinformationbirthday);
        employeeAddressEditText = findViewById(R.id.employeeinformationaddress);
        addButton = findViewById(R.id.saveemployee);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.sex_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        employeeSexSpinner.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEmployee();
            }
        });
    }

    private void addEmployee() {
        String employeeName = employeeNameEditText.getText().toString();
        String employeeID = employeeIDEditText.getText().toString();
        String employeePassword = employeePasswordEditText.getText().toString();
        String employeeSex = employeeSexSpinner.getSelectedItem().toString();
        String employeeBirthday = employeeBirthdayEditText.getText().toString();
        String employeeAddress = employeeAddressEditText.getText().toString();

        if (employeeName.isEmpty() || employeeID.isEmpty() || employeePassword.isEmpty() ||
                employeeSex.isEmpty() || employeeBirthday.isEmpty() || employeeAddress.isEmpty()) {
            return;
        }

        Employee newEmployee = new Employee(
                employeeName,
                employeeID,
                employeePassword,
                employeeSex,
                employeeBirthday,
                employeeAddress,
                0
        );
        finish();
    }
}
