package com.example.newproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class book extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        drawerLayout = findViewById(R.id.nav_view);


        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new ch1fragment());


        Toolbar toolbar = findViewById(R.id.toolbar);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.naviagtion_drawer_open, R.string.naviagtion_drawer_close);


        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new ch1fragment()).commit();
            navigationView.setCheckedItem(R.id.home);
        }

    }


    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.ch1:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new ch1fragment()).commit();
                break;
            case R.id.ch2:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new ch2fragment()).commit();
                break;

            case R.id.ch3:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new ch3fragment()).commit();
                break;

            case R.id.ch4:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new ch4fragment()).commit();
                break;

            case R.id.ch5:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new ch5fragment()).commit();
                break;


            case R.id.ch6:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new ch6fragment()).commit();
                break;


            case R.id.ch7:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new ch7fragment()).commit();
                break;


            case R.id.ch8:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new ch8fragment()).commit();
                break;


            case R.id.ch9:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new ch9fragment()).commit();
                break;


            case R.id.ch10:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new ch10fragment()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
