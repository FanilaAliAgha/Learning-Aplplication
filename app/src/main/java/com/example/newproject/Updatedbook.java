package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Updatedbook extends AppCompatActivity {
    public WebView updatedbook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedbook);

        updatedbook= findViewById(R.id.updatedbook);

        updatedbook.loadUrl("https://doc.rust-lang.org/book/");

        WebSettings ubookSettings = updatedbook.getSettings();
        ubookSettings.setJavaScriptEnabled(true);

    }
}