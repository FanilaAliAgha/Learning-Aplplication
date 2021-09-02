package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Youtubetutorial extends AppCompatActivity {
    public WebView Youtube_tutorials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtubetutorial);

        Youtube_tutorials= findViewById(R.id.Youtube_tutorials);

        Youtube_tutorials.loadUrl("https://youtube.com/playlist?list=PLVvjrrRCBy2JSHf9tGxGKJ-bYAN_uDCUL");

        WebSettings YtubeSettings = Youtube_tutorials.getSettings();
        YtubeSettings.setJavaScriptEnabled(true);

    }
}