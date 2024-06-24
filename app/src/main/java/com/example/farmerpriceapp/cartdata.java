package com.example.farmerpriceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class cartdata extends AppCompatActivity {

    RecyclerView recview;
    TextView rateview;
    Button buy;
    EditText t1,t2,t3,t4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartdata);

        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);

        findViewById(R.id.buynow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(cartdata.this, OrderSuccess.class));

            }
        });

        getSupportActionBar().hide();

        rateview=findViewById(R.id.rateview);
        getroomdata();
    }

    public void getroomdata()
    {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "cart_db").allowMainThreadQueries().build();
        ProductDao productDao = db.ProductDao();

        recview=findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        List<Product> products=productDao.getallproduct();

        myadapter adapter=new myadapter(products, rateview);
        recview.setAdapter(adapter);

        int sum=0,i;
        for(i=0;i< products.size();i++)
            sum=sum+(products.get(i).getPrice()*products.get(i).getQnt());

        rateview.setText("Total Amount : INR "+sum);
    }


}