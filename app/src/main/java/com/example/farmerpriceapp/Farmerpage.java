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

public class Farmerpage extends AppCompatActivity {

    Button farmer_community,farmersell;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_farmerpage);
        farmersell=findViewById(R.id.farsell);
        farmer_community=findViewById(R.id.Farcom);

        farmer_community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Farmerpage.this, FarmerCommunity.class));
            }
        });
        farmersell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Farmerpage.this, FarmerSell.class));
            }
        });
    }
}