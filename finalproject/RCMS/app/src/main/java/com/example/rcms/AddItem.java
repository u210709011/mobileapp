package com.example.rcms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class AddItem extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;

    private ImageView itemImageView;
    private EditText itemNameEditText, itemPriceEditText;
    private Spinner itemTypeSpinner;
    private Button addItemButton;

    private final ActivityResultLauncher<String> pickImageLauncher = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    handleImageResult(result);
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        itemImageView = findViewById(R.id.additemimage);
        itemNameEditText = findViewById(R.id.additemnameinput);
        itemPriceEditText = findViewById(R.id.additemprice);
        itemTypeSpinner = findViewById(R.id.additemtype);
        addItemButton = findViewById(R.id.additemaddemploye);

        itemImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add logic to handle adding the item to the menu (implement as needed)
                // For simplicity, just go back to the EditMenu activity
                finish();
            }
        });
    }

    private void openGallery() {
        pickImageLauncher.launch("image/*");
    }

    private void handleImageResult(Uri selectedImageUri) {
        // Handle the selected image from the gallery
        // For simplicity, set the selected image to the itemImageView
        itemImageView.setImageURI(selectedImageUri);
    }
}
