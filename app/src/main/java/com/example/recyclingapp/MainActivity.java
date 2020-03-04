package com.example.recyclingapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    String [] list;
    MaterialSearchView materialSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        //Adds "Hamburger" icon to tool bar to open and close drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Sets up listener for the drawer navigation items
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Checks if this is the first time the screen is being built, if so it will set the starting fragment view
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

        //SEARCH BAR CODE BELOW
        list = new String []{"one","two","three","four","five","six","seven","eight","nine","ten"};
        materialSearchView = findViewById(R.id.main_searchcomponent);
        materialSearchView.clearFocus();
        materialSearchView.closeSearch();
        materialSearchView.setSuggestions(list);
        materialSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Here Create your filtering
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //You can make change realtime if you typing here
                //See my tutorials for filtering with ListView
                return false;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.search_menu_search);
        materialSearchView.setMenuItem(item);

        return true;
    }

    //Callback for when item in Navigation view are pressed
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                //Places the Home fragment into the fragment frame layout we set up
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;
            case R.id.nav_queens:
                //Places the profile fragment into the fragment frame layout we set up
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new QueensFragment()).commit();
                break;
            case R.id.nav_guide:
                //Places the profile fragment into the fragment frame layout we set up
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new GuideFragment()).commit();
                break;
            case R.id.nav_aboutus:
                //Places the profile fragment into the fragment frame layout we set up
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutusFragment()).commit();
                break;
            case R.id.nav_resources:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ResourcesFragment()).commit();
                break;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
                break;
        }
        //Closes drawer after item has been selected
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

        if (materialSearchView.isSearchOpen()){
            materialSearchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }
}
