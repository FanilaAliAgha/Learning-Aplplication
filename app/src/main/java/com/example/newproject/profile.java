package com.example.newproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class profile extends AppCompatActivity {
    //    TextView
    private TextView User_ID, U_Email;
    //button
    private com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton logoutbtn;
    //Database
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth mAuth;
    //variables
    String uid;
    String Email;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        User_ID = findViewById(R.id.Users_id);
        U_Email = findViewById(R.id.Users_Email);
        logoutbtn = findViewById(R.id.logoutbtn);

        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();
        Email = user.getEmail();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("User");

        User_ID.setText(uid);
        U_Email.setText(Email);

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               FirebaseAuth.getInstance().signOut();

               startActivity(new Intent(profile.this, MainActivity.class));
            }
        });

    }
}