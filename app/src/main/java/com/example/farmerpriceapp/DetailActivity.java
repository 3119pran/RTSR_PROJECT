package com.example.farmerpriceapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DetailActivity extends AppCompatActivity {
    ImageView detailedImg;
    TextView price,rating,description;
    Button addtocart;
    ImageView additem,removeitem;
    Toolbar toolbar;
    TextView quantity;
    int totalquantity=1;
    int totalprice=0;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toolbar=findViewById(R.id.toolbar);
        setContentView(R.layout.activity_detail);
        detailedImg =findViewById(R.id.detailed_img);
        price=findViewById(R.id.detailed_price);
        description=findViewById(R.id.info);
        addtocart=findViewById(R.id.add_to_cart);
        quantity=findViewById(R.id.quantity);

        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailActivity.this, item_details.class));
            }
        });
    }
}