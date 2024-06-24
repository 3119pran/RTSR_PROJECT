package com.example.farmerpriceapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FarmerSell extends AppCompatActivity {
    EditText farmername, item, quantity_of_item;
    TextView result_of_item;
    Button farmersellbutton;
    DatabaseReference databaseReference;
    double totalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_sell);

        // Initialize the EditText, Button, and TextView fields
        farmername = findViewById(R.id.farmername);
        item = findViewById(R.id.item_farmer);
        quantity_of_item = findViewById(R.id.quantity);
        result_of_item = findViewById(R.id.result_farmer);
        farmersellbutton = findViewById(R.id.farmer_sell_Button);

        databaseReference= FirebaseDatabase.getInstance().getReference("FarmerSellingItems");

        // Set the onClickListener for the button
        farmersellbutton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String itemName = item.getText().toString();
                String itemQuantity = quantity_of_item.getText().toString();

                // Check if the item name and quantity are not empty
                ;
                if (!itemName.isEmpty() && !itemQuantity.isEmpty()) {
                    try {
                        double pricePerUnit = 0;
                        double itemquantity = Double.parseDouble(itemQuantity);
                        if(itemName.equals("Tomato")){
                         pricePerUnit = 15.0;}
                        else if (itemName.equals("Rice")) {
                            pricePerUnit = 50.0;}
                        else if (itemName.equals("Potato"))  {
                            pricePerUnit = 40.0;
                        }
                        else if (itemName.equals("Beans"))  {
                            pricePerUnit = 25.0;
                        }
                        else if (itemName.equals("cabbage"))  {
                            pricePerUnit = 15.0;
                        }
                        totalCost = pricePerUnit * itemquantity;
                        result_of_item.setText("Item: " + itemName + "\nQuantity: " + itemQuantity + "\nTotal Price: Rs" + totalCost + "\nSubmission Successful!");
                    } catch (NumberFormatException e) {
                        result_of_item.setText("Please enter a valid quantity.");
                    }
                } else {
                    result_of_item.setText("Please enter item name and quantity.");
                }
                insertdata();
            }
        });
    }
    private void insertdata() {
        String farmername=this.farmername.getText().toString();
        String item=this.item.getText().toString();
        String quantity=this.quantity_of_item.getText().toString();
        String total= String.valueOf(totalCost);
        FarmerSellingItems f=new FarmerSellingItems(farmername,item,quantity,total);
        databaseReference.push().setValue(f);
        Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
    }
}
