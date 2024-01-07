package com.example.rcms;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class AddEmployee extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;

    private ImageView employeeImageView;
    private EditText nameEditText, idEditText, passwordEditText, birthdayEditText, addressEditText;
    private Spinner sexSpinner;
    private Button addEmployeeButton;

    private final ActivityResultLauncher<String> pickImageLauncher = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            result -> {
                if (result != null) {
                    handleImageResult(result);
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        employeeImageView = findViewById(R.id.addemployeeinformationimage);
        nameEditText = findViewById(R.id.addemployeeinformationname);
        idEditText = findViewById(R.id.addemployeeinformationid);
        passwordEditText = findViewById(R.id.addemployeeinformationpassword);
        birthdayEditText = findViewById(R.id.addemployeeinformationbirthday);
        addressEditText = findViewById(R.id.addemployeeinformationaddress);
        sexSpinner = findViewById(R.id.addemployeeinformationsex);
        addEmployeeButton = findViewById(R.id.addemployee);

        employeeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });

        addEmployeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add logic to handle adding the employee (implement as needed)
                // For simplicity, just go back to the EditEmployee activity
                finish();
            }
        });
    }

    private void openGallery() {
        pickImageLauncher.launch("image/*");
    }

    private void handleImageResult(Uri selectedImageUri) {
        // Handle the selected image from the gallery
        // For simplicity, set the selected image to the employeeImageView
        employeeImageView.setImageURI(selectedImageUri);
    }
}
