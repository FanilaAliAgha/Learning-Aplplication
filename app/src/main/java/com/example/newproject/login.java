package com.example.newproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class login extends AppCompatActivity {

    public com.google.android.material.textfield.TextInputLayout Email;
    public com.google.android.material.textfield.TextInputLayout Password;
    public com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton loginbtn;
    public com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton guestbtn;
    public com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton forgotpass;
    public Button createnewacc;

//Database

    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //login back end code
//casting
        Email = (TextInputLayout) findViewById(R.id.Email);
        Password = (TextInputLayout) findViewById(R.id.Password);
        loginbtn = (ExtendedFloatingActionButton) findViewById(R.id.loginbtn);
        guestbtn = (ExtendedFloatingActionButton) findViewById(R.id.guestbtn);
        forgotpass = (ExtendedFloatingActionButton) findViewById(R.id.forgotpass);
        createnewacc = (Button) findViewById(R.id.createnewacc);


        createnewacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(login.this, signupformm.class);
                startActivity(a);
            }
        });


        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(login.this, forgotpassword.class);
                startActivity(b);
            }
        });


        //guestbtn
        guestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, guestdboard.class);
                startActivity(intent);
            }
        });
//Authentication
        mAuth = FirebaseAuth.getInstance();
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getEditText().getText().toString();
                String password = Password.getEditText().getText().toString();


                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(login.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(login.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }

//Login coding
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(), dashboard.class));
                                    finish();

                                } else {
                                    Toast.makeText(login.this, "Login Failed!!!", Toast.LENGTH_SHORT).show();
                                    isUser();
                                }

                            }

                            private void isUser() {

                                String UserEnteredEmail = Email.getEditText().getText().toString().trim();
                                String UserEnteredPassword = Password.getEditText().getText().toString().trim();


                                databaseReference = FirebaseDatabase.getInstance().getReference("User");
                                Query checkUser = databaseReference.orderByChild("Email").equalTo(UserEnteredEmail);

//                                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
//                                    @Override
//                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                        if (snapshot.exists()) {
//                                            Email.setError(null);
//                                            Email.setErrorEnabled(false);
//
//
//                                            String PasswordFromDB = snapshot.child(UserEnteredEmail).child("password").getValue(String.class);
//
//                                            if (PasswordFromDB.equals(UserEnteredPassword)) {
//                                                Email.setError(null);
//                                                Email.setErrorEnabled(false);
//
//
//                                                String NameFromDB   = snapshot.child(UserEnteredEmail).child("Name").getValue(String.class);
//                                                String EmailFromDB = snapshot.child(UserEnteredEmail).child("Email").getValue(String.class);
//                                                PasswordFromDB = snapshot.child(UserEnteredEmail).child("Password").getValue(String.class);
//
//                                                Intent intent = new Intent(getApplicationContext(), profile.class);
//                                                intent.putExtra("Name", NameFromDB);
//                                                intent.putExtra("Email", EmailFromDB);
//
//                                                startActivity(intent);
//                                            } else {
//                                                Password.setError("Wrong Password");
//                                                Password.requestFocus();
//                                            }
//                                        } else {
//
//                                            Email.setError("No such user exist");
//                                            Password.setError("No such password exist");
//                                        }
//
//                                    }
//
//                                    @Override
//                                    public void onCancelled(@NonNull DatabaseError error) {
//
//                                    }
//                                });


                            }
                        }
                );

            }
        });
    }

}