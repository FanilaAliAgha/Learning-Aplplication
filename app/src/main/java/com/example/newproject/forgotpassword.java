package com.example.newproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class forgotpassword extends AppCompatActivity {

    public com.google.android.material.textfield.TextInputLayout Emailf;
    public com.google.android.material.textfield.TextInputLayout Usernamef;
    public com.google.android.material.button.MaterialButton resetbtn;
    public com.google.android.material.textfield.TextInputLayout OldPasswordf;

    FirebaseAuth mAuth;

    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

// this is used to set page for forgot pas
private  String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        resetbtn = findViewById(R.id.resetbtn);
        Emailf = findViewById(R.id.Emailf);
        OldPasswordf = findViewById(R.id.OldPasswordf);
        Usernamef = findViewById(R.id.Usernamef);


        mAuth = FirebaseAuth.getInstance();

        //real time database
        databaseReference = FirebaseDatabase.getInstance().getReference("User");



        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }

            private void validateData() {
                email = Emailf.getEditText().getText().toString();
                if (email.isEmpty()){
                    Emailf.setError("Required");
                }else
                {
                    forgotpass();
                }

            }

            private void forgotpass() {
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(forgotpassword.this, "Check Your Email", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(forgotpassword.this,login.class));
                            finish();
                        }
                        else {
                            Toast.makeText(forgotpassword.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                         }

                    }
                });

            }
        });

    }
}