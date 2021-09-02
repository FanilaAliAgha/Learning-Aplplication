package com.example.newproject;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class uploadfile extends AppCompatActivity {
    public com.google.android.material.textfield.TextInputLayout code;
    public com.google.android.material.textfield.TextInputLayout Filename;
    public com.google.android.material.textfield.TextInputLayout Codersname;
    String UserID;

    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadfile);
    }

    public void process(View view) {
        Filename = findViewById(R.id.Filename);
        code = findViewById(R.id.code);
        Codersname = findViewById(R.id.Codersname);
        String name_of_coder = Codersname.getEditText().getText().toString().trim();
        String name_of_file = Filename.getEditText().getText().toString().trim();
        String code_of_file = code.getEditText().getText().toString().trim();

        Udataholder obj = new Udataholder(name_of_coder, name_of_file, code_of_file);

        FirebaseDatabase db = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = db.getReference("Udataholder");

        databaseReference.child(name_of_coder).setValue(obj);

        Codersname.getEditText().setText("");
        Filename.getEditText().setText("");
        code.getEditText().setText("");

        if (TextUtils.isEmpty(name_of_coder)) {
            Toast.makeText(uploadfile.this, "Please Enter Name of Coder", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(name_of_file)) {
            Toast.makeText(uploadfile.this, "Please Enter File Name", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(code_of_file)) {
            Toast.makeText(uploadfile.this, "Please Enter Code in the file", Toast.LENGTH_SHORT).show();
        }
        else{

        Toast.makeText(this, "Value Inserted Successfully", Toast.LENGTH_SHORT).show();
    }
}
}
