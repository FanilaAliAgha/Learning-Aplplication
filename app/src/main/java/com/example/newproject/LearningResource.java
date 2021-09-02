package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LearningResource extends AppCompatActivity {
    private Button ubookbtn, tutorialbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_resource);

        ubookbtn = findViewById(R.id.ubookbtn);
        tutorialbtn = findViewById(R.id.tutorialbtn);

        //Button2 Updated book
        ubookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearningResource.this, Updatedbook.class);
                startActivity(intent);
            }
        });


        tutorialbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearningResource.this, Youtubetutorial.class);
                startActivity(intent);
            }
        });
    }
}