package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class uploads extends AppCompatActivity {
    RecyclerView recview;
    MyUadapter uadapter;
    com.google.android.material.floatingactionbutton.FloatingActionButton floating_action_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploads);
        floating_action_button = (com.google.android.material.floatingactionbutton.FloatingActionButton) findViewById(R.id.floating_action_button);
        recview = (RecyclerView) findViewById(R.id.recview);
        floating_action_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(uploads.this, uploadfile.class);
                startActivity(intent);}});
        recview.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<model> options =
         new FirebaseRecyclerOptions.Builder<model>().setQuery(FirebaseDatabase.getInstance().getReference().child("Udataholder"), model.class).build();
        uadapter = new MyUadapter(options);
        recview.setAdapter(uadapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        uadapter.startListening();}
    @Override
    protected void onStop() {
        super.onStop();
        uadapter.stopListening();
    }
}