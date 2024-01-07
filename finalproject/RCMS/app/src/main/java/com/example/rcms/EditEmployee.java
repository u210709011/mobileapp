package com.example.rcms;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class EditEmployee extends AppCompatActivity {

    private RecyclerView recyclerViewEditEmployee;
    private EditEmployeeAdapter editEmployeeAdapter;
    private ArrayList<Employee> employeeList; // Provide your data here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee);

        recyclerViewEditEmployee = findViewById(R.id.recyclervieweditemployee);
        recyclerViewEditEmployee.setLayoutManager(new LinearLayoutManager(this));

        employeeList = new ArrayList<>();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employee1.setName("APO BABA");
        employee1.setID("31");

        employee2.setName("Ryan Gosling");
        employee2.setID("69");

        employeeList.add(employee1);
        employeeList.add(employee2);

        // Create an instance of EditEmployeeAdapter
        editEmployeeAdapter = new EditEmployeeAdapter(this, employeeList);

        // Set the EditEmployeeAdapter as the adapter for the RecyclerView
        recyclerViewEditEmployee.setAdapter(editEmployeeAdapter);
    }
}
