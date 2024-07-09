package com.example.farmerpriceapp;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Delivery_Details extends AppCompatActivity {

    private EditText etName, etAddress, etPhoneNumber;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_details);

        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitDeliveryDetails();
            }
        });
    }

    private void submitDeliveryDetails() {
        String name = etName.getText().toString().trim();
        String address = etAddress.getText().toString().trim();
        String phoneNumber = etPhoneNumber.getText().toString().trim();

        if (name.isEmpty() || address.isEmpty() || phoneNumber.isEmpty()) {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
        } else {
            // Handle the delivery details submission (e.g., save to database or send to server)
            Toast.makeText(this, "Details submitted successfully!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Delivery_Details.this, OrderSuccess.class));
        }
    }
}
