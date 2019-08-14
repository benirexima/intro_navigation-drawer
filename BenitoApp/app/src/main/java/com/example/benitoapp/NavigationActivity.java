package com.example.benitoapp;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    DrawerLayout dLayout;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navView = (NavigationView) findViewById(R.id.nav);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, dLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        dLayout.addDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (dLayout.isDrawerOpen(GravityCompat.START)) {
            dLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (item.isChecked()) {
            dLayout.closeDrawer(GravityCompat.START);
            return false;
        }

        if (id == R.id.one) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        } else if (id == R.id.two) {
            startActivity(new Intent(getApplicationContext(), SecondActivity.class));
        } else if (id == R.id.three) {
            startActivity(new Intent(getApplicationContext(), RealmActivity.class));
        }

        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        dLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
