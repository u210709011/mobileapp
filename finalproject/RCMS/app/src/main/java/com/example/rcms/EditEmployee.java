package com.example.rcms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class EditEmployee extends AppCompatActivity implements EditEmployeeAdapter.OnEmployeeClickListener {

    private RecyclerView recyclerViewEditEmployee;
    private EditEmployeeAdapter editEmployeeAdapter;
    private ArrayList<Employee> employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee);

        recyclerViewEditEmployee = findViewById(R.id.recyclervieweditemployee);
        recyclerViewEditEmployee.setLayoutManager(new LinearLayoutManager(this));

        Button buttonAddEmployee = findViewById(R.id.editemployeeaddbutton);
        buttonAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditEmployee.this, AddEmployee.class);
                startActivity(intent);
            }
        });


        employeeList = new ArrayList<>();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employee1.setName("APO BABA");
        employee1.setID("31");

        employee2.setName("Ryan Gosling");
        employee2.setID("69");

        employeeList.add(employee1);
        employeeList.add(employee2);

        editEmployeeAdapter = new EditEmployeeAdapter(this, employeeList,this);

        recyclerViewEditEmployee.setAdapter(editEmployeeAdapter);
    }

    @Override
    public void onEmployeeClick(int position) {
        Intent intent = new Intent(EditEmployee.this, EmployeeInformation.class);
        intent.putExtra("employeeName", employeeList.get(position).getName());
        intent.putExtra("employeeID", employeeList.get(position).getID());
        startActivity(intent);
    }
}
