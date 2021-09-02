package com.example.newproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class guestdboard extends AppCompatActivity {

    public androidx.cardview.widget.CardView gcard1;
    public androidx.cardview.widget.CardView gcard2;
    public androidx.cardview.widget.CardView gcard3;
    public androidx.cardview.widget.CardView gcard4;
    public androidx.cardview.widget.CardView gcard5;
    public androidx.cardview.widget.CardView gcard6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guestdboard);

        gcard1 =findViewById(R.id.gcard1);
        gcard2 =findViewById(R.id.gcard2);
        gcard3 =findViewById(R.id.gcard3);
        gcard4 =findViewById(R.id.gcard4);
        gcard5 =findViewById(R.id.gcard5);
        gcard6 =findViewById(R.id.gcard6);

        gcard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(guestdboard.this, "This Action Requires Login...", Toast.LENGTH_SHORT).show();
            }
        });

        gcard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(guestdboard.this, "This Action Requires Login...", Toast.LENGTH_SHORT).show();
            }
        });
        gcard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(guestdboard.this, "This Action Requires Login...", Toast.LENGTH_SHORT).show();
            }
        });

        gcard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(guestdboard.this, "This Action Requires Login...", Toast.LENGTH_SHORT).show();
            }
        });

        gcard5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(guestdboard.this, "This Action Requires Login...", Toast.LENGTH_SHORT).show();
            }
        });

        gcard6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(guestdboard.this, "This Action Requires Login...", Toast.LENGTH_SHORT).show();
            }
        });


        gcard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(guestdboard.this, "This Action Requires Login...", Toast.LENGTH_SHORT).show();
            }
        });

        

        

    }
}