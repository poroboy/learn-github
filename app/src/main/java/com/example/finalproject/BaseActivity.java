package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public abstract class BaseActivity extends AppCompatActivity {

    protected DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawerLayout = findViewById(R.id.drawer_layout);
        // Initialize the NavigationView
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                navigateTo(item.getItemId());
                drawerLayout.closeDrawer(GravityCompat.START);  // Close the navigation drawer
                return true;
            }
        });
    }

    private void navigateTo(int itemId) {
        if (itemId == R.id.nav_buynewplan) {
            startActivity(new Intent(this, MyPlanActivity.class));
        } else if (itemId == R.id.nav_buynewplan) {
            startActivity(new Intent(this, HomePageActivity.class));
        }

    }
}
