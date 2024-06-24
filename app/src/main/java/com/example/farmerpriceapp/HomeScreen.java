package com.example.farmerpriceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Button storeButton = findViewById(R.id.button_store);
        Button farmersButton = findViewById(R.id.button_farmers);

        storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to execute when the Store button is clicked
                startActivity(new Intent(HomeScreen.this, StoreActivity.class));
            }
        });

        farmersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to execute when the Farmers button is clicked
                startActivity(new Intent(HomeScreen.this, FramersActivity.class));
            }
        });
    }
}