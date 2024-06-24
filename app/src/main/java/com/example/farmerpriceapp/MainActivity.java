// src/main/java/com/example/farmerpriceapp/MainActivity.java
package com.example.farmerpriceapp;



import android.app.Activity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;

import android.util.Log;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.widget.Spinner;
import android.widget.TextView;


import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView text,dialog_language,login,register,email,password,rateview;
    int lang_selected;
    RelativeLayout show_lan_dialog;


    Context context;
    Resources resources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text =(TextView)findViewById(R.id.welcomeText);
        dialog_language = (TextView)findViewById(R.id.dialog_language);
        show_lan_dialog = (RelativeLayout)findViewById(R.id.showlangdialog);
        login= (TextView)findViewById(R.id.loginButton);
        register= (TextView)findViewById(R.id.registerButton);
        rateview=(TextView)findViewById(R.id.rateview);


        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        findViewById(R.id.registerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });



        if(LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("en"))
        {
            context = LocaleHelper.setLocale(MainActivity.this,"en");
            resources =context.getResources();
            dialog_language.setText("ENGLISH");

            text.setText(resources.getString(R.string.welcome));
            setTitle(resources.getString(R.string.app_name));
            login.setText(resources.getString(R.string.login));
            register.setText(resources.getString(R.string.register));


            lang_selected = 0;

        }else if(LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("hi")){
            context = LocaleHelper.setLocale(MainActivity.this,"te");
            resources =context.getResources();
            dialog_language.setText("Telugu");

            text.setText(resources.getString(R.string.welcome));
            setTitle(resources.getString(R.string.app_name));
            login.setText(resources.getString(R.string.login));
            register.setText(resources.getString(R.string.register));


            lang_selected =1;
        }

        show_lan_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] Language = {"ENGLISH","Telugu"};
                final int checkItem;
                Log.d("Clicked","Clicked");


                final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                dialogBuilder.setTitle("Select a Language")
                        .setSingleChoiceItems(Language, lang_selected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialog_language.setText(Language[i]);

                                if(Language[i].equals("ENGLISH")){
                                    context = LocaleHelper.setLocale(MainActivity.this,"en");
                                    resources =context.getResources();
                                    lang_selected = 0;

                                    text.setText(resources.getString(R.string.welcome));
                                    setTitle(resources.getString(R.string.app_name));
                                    login.setText(resources.getString(R.string.login));
                                    register.setText(resources.getString(R.string.register));

                                }
                                if(Language[i].equals("Telugu"))
                                {
                                    context = LocaleHelper.setLocale(MainActivity.this,"te");
                                    resources =context.getResources();
                                    lang_selected = 1;

                                    text.setText(resources.getString(R.string.welcome));
                                    setTitle(resources.getString(R.string.app_name));
                                    login.setText(resources.getString(R.string.login));
                                    register.setText(resources.getString(R.string.register));

                                }

                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                dialogBuilder.create().show();
            }
        });

    }
}
