package com.example.newproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signupformm extends AppCompatActivity {

    TextInputLayout Namebox, Emailbox, Passwordbox;
    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton signupbtn, cancelbtn;
    String UserID;

//Database
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupformm);
//casting
        Namebox = (TextInputLayout) findViewById(R.id.Namebox);
        Emailbox = (TextInputLayout) findViewById(R.id.Emailbox);
        Passwordbox = (TextInputLayout) findViewById(R.id.Passwordbox);
        signupbtn = findViewById(R.id.signupbtn);
        cancelbtn = findViewById(R.id.cancelbtn);

//real time database
        databaseReference = FirebaseDatabase.getInstance().getReference("User");
//Authentication
        mAuth = FirebaseAuth.getInstance();



        //cancel btn
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(signupformm.this,MainActivity.class);
                startActivity(intent);
            }
        });

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = Emailbox.getEditText().getText().toString();
                String Password = Passwordbox.getEditText().getText().toString();
                String Name = Namebox.getEditText().getText().toString();

                if (TextUtils.isEmpty(Email)) {
                    Toast.makeText(signupformm.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(Name)) {
                    Toast.makeText(signupformm.this, "Please Enter Full Name", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(Password)) {
                    Toast.makeText(signupformm.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }

                //Signup coding

                    mAuth.createUserWithEmailAndPassword(Email, Password)
                            .addOnCompleteListener(signupformm.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    User information = new User(
                                            Name,
                                            Email,
                                            Password
                                    );
                                    FirebaseDatabase.getInstance().getReference("User")
                                            .child(mAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(signupformm.this, "REGISTERED SUCCSSFULLy", Toast.LENGTH_SHORT).show();

                                            //Intented is created here

                                            startActivity(new Intent(signupformm.this,login.class));
                                            finish();

                                        }
                                    });


                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(signupformm.this, "Some Error Occured", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });

    }


}