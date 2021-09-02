package com.example.newproject;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class dashboard extends AppCompatActivity {
    public androidx.cardview.widget.CardView card1;
    public androidx.cardview.widget.CardView card2;
    public androidx.cardview.widget.CardView card3;
    public androidx.cardview.widget.CardView card4;
    public androidx.cardview.widget.CardView card5;
    public androidx.cardview.widget.CardView card6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        card1 = (androidx.cardview.widget.CardView) findViewById(R.id.card1);
        card2 = (androidx.cardview.widget.CardView) findViewById(R.id.card2);
        card3 = (androidx.cardview.widget.CardView) findViewById(R.id.card3);
        card4 = (androidx.cardview.widget.CardView) findViewById(R.id.card4);
        card5 = (androidx.cardview.widget.CardView) findViewById(R.id.card5);
        card6 = (androidx.cardview.widget.CardView) findViewById(R.id.card6);


        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bookintent = new Intent(dashboard.this, book.class);
                startActivity(bookintent);
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(dashboard.this, code.class);
                startActivity(s);
            }
        });


        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AQ = new Intent(dashboard.this, attemptquiz.class);
                startActivity(AQ);
            }
        });

//        card2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(dashboard.this , attemptquiz.class);
//
//                startActivity(intent);
//            }
//        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, uploads.class);
                startActivity(intent);
            }
        });


        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dashboard.this,LearningResource.class);
                startActivity(intent);
            }
        });


        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, profile.class);
                startActivity(intent);
            }
        });
    }
}