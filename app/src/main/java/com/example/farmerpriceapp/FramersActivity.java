package com.example.farmerpriceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FramersActivity extends AppCompatActivity {
    Button submit ;
    EditText farmername,area,village;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_framers);
        submit=findViewById(R.id.farmerButton);
        farmername=findViewById(R.id.farmername);
        area=findViewById(R.id.area);
        village=findViewById(R.id.village);


        databaseReference= FirebaseDatabase.getInstance().getReference("Farmer");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertdata();
                startActivity(new Intent(FramersActivity.this, Farmerpage.class));
            }
        });

    }
    private void insertdata() {
        String farmername=this.farmername.getText().toString();
        String area=this.area.getText().toString();
        String village=this.village.getText().toString();
        Farmer f=new Farmer(farmername,area,village);
        databaseReference.push().setValue(f);
        Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
    }
}