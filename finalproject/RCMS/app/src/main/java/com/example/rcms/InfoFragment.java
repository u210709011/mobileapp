package com.example.rcms;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class InfoFragment extends Fragment {


    private static final String ARG_EMPLOYEE_NAME = "employee_name";
    private static final String ARG_EMPLOYEE_ID = "employee_id";
    private static final String ARG_TIME_WORKED = "time_worked";

    private String employeeName = "";
    private String employeeId = "";
    private String timeWorked = "";

    public InfoFragment() {
    }


    public static InfoFragment newInstance(String employeeName, String employeeId, int timeWorked) {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_EMPLOYEE_NAME, employeeName);
        args.putString(ARG_EMPLOYEE_ID, employeeId);
        args.putInt(ARG_TIME_WORKED, timeWorked);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            employeeName = getArguments().getString(ARG_EMPLOYEE_NAME, "");
            employeeId = getArguments().getString(ARG_EMPLOYEE_ID, "");
            timeWorked = getArguments().getString(ARG_TIME_WORKED, "");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textViewEmployeeName = view.findViewById(R.id.textViewEmployeeName);
        TextView textViewEmployeeId = view.findViewById(R.id.textViewEmployeeId);
        TextView textViewTimeWorked = view.findViewById(R.id.textViewTimeWorked);
        Button buttonLogOut = view.findViewById(R.id.buttonLogOut);
        ImageButton buttonHome = view.findViewById(R.id.buttonHome);

        textViewEmployeeName.setText("Employee Name: " + employeeName);
        textViewEmployeeId.setText("Employee ID: " + employeeId);
        textViewTimeWorked.setText("Time Worked: " + timeWorked);

        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginScreen.class);
                startActivity(intent);
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NavigationMenu.class);
                startActivity(intent);
            }
        });

    }
}