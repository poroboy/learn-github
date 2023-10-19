package com.example.finalproject;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;


public class HomePageActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ServiceAdapter serviceAdapter;
    private TextView userNameIDTextView;
    private NavigationManager navigationManager;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home_page);

            recyclerView = findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            drawerLayout = findViewById(R.id.drawer_layout);
            toolbar = findViewById(R.id.toolbar);
            navigationView = findViewById(R.id.nav_view);
            NavigationView navigationView = findViewById(R.id.nav_view);


            View headerView = navigationView.getHeaderView(0);
            userNameIDTextView = headerView.findViewById(R.id.header_name);
            String userID = getIntent().getStringExtra("userID");
            userNameIDTextView.setText(userID);

            // Create a list of services
            List<Service> serviceList = new ArrayList<>();
            serviceList.add(new Service("Car Insurance", "Insurance for cars", R.drawable.car_icon));
            serviceList.add(new Service("Motorcycle Insurance", "Insurance for motorcycles", R.drawable.motorcycle_icon));
            serviceList.add(new Service("Health Insurance", "Insurance for health", R.drawable.health_icon));

            // Create and set the adapter
            serviceAdapter = new ServiceAdapter(serviceList);
            recyclerView.setAdapter(serviceAdapter);

            // Set the recommendation text
            TextView recommendationTextView = findViewById(R.id.tv_recommendation);
            recommendationTextView.setText("Recommendation: Choose the insurance that best suits your needs.");

            setSupportActionBar(toolbar);

            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();
        }
    }
