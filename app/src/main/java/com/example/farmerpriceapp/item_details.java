package com.example.farmerpriceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class item_details extends AppCompatActivity
{
    EditText t1,t2,t3,t4;
    Button b1,b2;
    TextView lbl;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);

        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        lbl=findViewById(R.id.lbl);
        databaseReference= FirebaseDatabase.getInstance().getReference("Order details");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"cart_db").allowMainThreadQueries().build();
                ProductDao productDao=db.ProductDao();
                Boolean check=productDao.is_exist(Integer.parseInt(t1.getText().toString()));
                if(check==false)
                {
                    int pid=Integer.parseInt(t1.getText().toString());
                    String pname=t2.getText().toString();
                    int price=Integer.parseInt(t3.getText().toString());
                    int qnt=Integer.parseInt(t4.getText().toString());
                    productDao.insertrecord(new Product(pid,pname,price,qnt));
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    lbl.setText("Product Inserted Successfully");
                }
                else
                {
                    insertdata();
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    lbl.setText("Product Already in Cart");
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),cartdata.class));

            }
        });
    }
    private void insertdata() {
        String id = this.t1.getText().toString();
        String itemName = this.t2.getText().toString();
        String productPrice = this.t3.getText().toString();
        String productQuantity = this.t4.getText().toString();
        Order order = new Order(id, itemName, productPrice, productQuantity);
        databaseReference.push().setValue(order);
        Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
    }
}