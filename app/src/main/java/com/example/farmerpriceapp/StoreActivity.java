package com.example.farmerpriceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.farmerpriceapp.R;
import com.google.android.material.navigation.NavigationView;

public class StoreActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageButton buttonDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_store);
        drawerLayout=findViewById(R.id.drawerLayout);
        buttonDrawerToggle=findViewById(R.id.buttonDrawerToggle);
        navigationView =findViewById(R.id.navigationview);
        buttonDrawerToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.open();
            }
        });
        View headerview=navigationView.getHeaderView(0);
        ImageView userImage=headerview.findViewById(R.id.userImage);
        TextView textusername=headerview.findViewById(R.id.textUsername);
        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StoreActivity.this, textusername.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemid=item.getItemId();
                if(itemid==R.id.navmenu){
                    Toast.makeText(StoreActivity.this, "Menu Clicked", Toast.LENGTH_SHORT).show();
                }
                if(itemid==R.id.navcart){
                    Toast.makeText(StoreActivity.this, "Cart Clicked", Toast.LENGTH_SHORT).show();
                }
                if(itemid== R.id.navfav){
                    Toast.makeText(StoreActivity.this, "fav Clicked", Toast.LENGTH_SHORT).show();
                }
                if(itemid==R.id.navorder){
                    Toast.makeText(StoreActivity.this, "order Clicked", Toast.LENGTH_SHORT).show();
                }
                if(itemid==R.id.navcontact){
                    Toast.makeText(StoreActivity.this, "Contact Clicked", Toast.LENGTH_SHORT).show();
                }
                if(itemid==R.id.navTerms){
                    Toast.makeText(StoreActivity.this, "Terms Clicked", Toast.LENGTH_SHORT).show();
                }
                if(itemid==R.id.navfeedback){
                    Toast.makeText(StoreActivity.this, "Feedback Clicked", Toast.LENGTH_SHORT).show();
                }
                drawerLayout.close();;
                return false;
            }
        });
        findViewById(R.id.ar1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreActivity.this,DetailActivity.class));
            }
        });
        findViewById(R.id.ar2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreActivity.this, DetailActivity1.class));
            }
        });
        findViewById(R.id.ar3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreActivity.this, DetailActivity3.class));
            }
        });
        findViewById(R.id.ar4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreActivity.this, DetailActivity2.class));
            }
        });
        findViewById(R.id.ar5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreActivity.this, DetailActivity.class));
            }
        });
    }
}