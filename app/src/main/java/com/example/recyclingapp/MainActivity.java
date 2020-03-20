package com.example.recyclingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.recyclingapp.fragments.AboutusFragment;
import com.example.recyclingapp.fragments.GuideFragment;
import com.example.recyclingapp.fragments.HomeFragment;
import com.example.recyclingapp.fragments.QueensFragment;
import com.example.recyclingapp.fragments.ResourcesFragment;
import com.example.recyclingapp.fragments.SettingsFragment;
import com.google.android.material.navigation.NavigationView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "RUH OH";
    DrawerLayout drawer;

    String[] mItemList;
    String[] mBinList;

    MaterialSearchView materialSearchView;
    private static NavigationView navigationView;

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
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Checks if this is the first time the screen is being built, if so it will set the starting fragment view
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

        //Creating lists of items and their bins
        mItemList = getItemLists();
        mBinList = getBinLists();

        //SEARCH BAR CODE BELOW
        materialSearchView = findViewById(R.id.main_searchcomponent);
        materialSearchView.clearFocus();
        materialSearchView.closeSearch();
        materialSearchView.setSuggestions(mItemList);
        materialSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Here Create your filtering

                //When you tap an option and click the search button it will contain the query.
                //Forces it to be an option within the list

                if (query != "") {
                    int position = getPosition(mItemList, query);
                    if (position != -1)
                        openDialog(position, mItemList, mBinList);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //You can make change realtime if you typing here
                //See my tutorials for filtering with ListView
//                Log.i(TAG, "CLICKKK");

                return false;
            }
        });
        materialSearchView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String data = (String) parent.getItemAtPosition(position);
                int pos = getPosition(mItemList, data);
                if (pos != -1)
                openDialog(pos, mItemList, mBinList );
                materialSearchView.closeSearch();
            }
        });
    }

    private int getPosition(String[] mItemList, String query) {
        for (int i = 0; i < mItemList.length; i++) {
            if (mItemList[i].equals(query))
                return i;
        }
        return -1;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.search_menu_search);
        materialSearchView.setMenuItem(item);
        return true;
    }

    public void openDialog(int position, String[] itemList, String[] binList) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.alert_dialog_items, null);
        TextView itemName = view.findViewById(R.id.alert_itemName);
        TextView itemBin = view.findViewById(R.id.alert_itemBin);
        itemName.setText(itemList[position]);
        itemBin.setText(binList[position]);
        Button closeBtn = view.findViewById(R.id.alert_close_btn);

        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();
        alertDialog.show();
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });
    }

    //Callback for when item in Navigation view are pressed
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                //Places the Home fragment into the fragment frame layout we set up
                SwitchFragment(new HomeFragment());
                break;
            case R.id.nav_queens:
                //Places the profile fragment into the fragment frame layout we set up
                SwitchFragment(new QueensFragment());
                break;
            case R.id.nav_guide:
                //Places the profile fragment into the fragment frame layout we set up
                SwitchFragment(new GuideFragment());
                break;
            case R.id.nav_aboutus:
                //Places the profile fragment into the fragment frame layout we set up
                SwitchFragment(new AboutusFragment());
                break;
            case R.id.nav_resources:
                SwitchFragment(new ResourcesFragment());
                break;
            case R.id.nav_settings:
                SwitchFragment(new SettingsFragment());
                break;
        }
        //Closes drawer after item has been selected
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void SwitchFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    public static void SetCheckedMenuItem(int menuItem) {
        navigationView.setCheckedItem(menuItem);
    }

    public String[] getItemLists() {
        String[] itemList = {
                "Newspaper", "General paper", "Cardboard", "Paper cups",
                "Grocery bags", "Tetra pack", "Shredded paper", "Cereal boxes",
                "Toilet paper", "Pie plates", "Paper towel tubes",

                "Tissues (used)", "Pizza box (Greasy)",
                "Meat", "Fish", "Dairy", "Fruits",
                "Vegetables", "Paper towel", "Grain", "Grease/Fat",
                "Soiled paper", "Tea Bags", "Yard waste", "Paper plates",
                "House plants", "Butter", "Margarine", "Egg shells",
                "Coffee grounds", "Coffee filters",

                "Household hard plastics", "Tin", "Aluminum", "Glass jar",
                "Bottle cap", "Beer can", "Soup can", "White styrofoam",

                "Aerosol can", "Batteries", "Antifreeze", "Fertilizer",
                "Light bulb", "Gasoline", "Oil", "Paint",
                "Fire extinguisher", "Propane cylinder", "Fuel", "Adhesive", "Thermostat",

                "Colored styrofoam", "Broken glass", "Bubble wrap", "Meat packaging",
                "Plastic toys", "Ziploc bags", "Single-use coffee pods", "Dryer sheets"};

        return itemList;
    }

    public String[] getBinLists() {
        String[] binList = {
                "Grey Bin", "Grey Bin", "Grey Bin", "Grey Bin", "Grey Bin",
                "Grey Bin", "Grey Bin", "Grey Bin", "Grey Bin", "Grey Bin", "Grey Bin",
                "Green Bin", "Green Bin", "Green Bin", "Green Bin", "Green Bin", "Green Bin",
                "Green Bin", "Green Bin", "Green Bin", "Green Bin", "Green Bin", "Green Bin",
                "Green Bin", "Green Bin", "Green Bin", "Green Bin", "Green Bin", "Green Bin",
                "Green Bin", "Green Bin",
                "Blue Bin", "Blue Bin", "Blue Bin", "Blue Bin",
                "Blue Bin", "Blue Bin", "Blue Bin", "Blue Bin",
                "Special", "Special", "Special", "Special", "Special", "Special",
                "Special", "Special", "Special", "Special", "Special", "Special",
                "Special",
                "Garbage", "Garbage", "Garbage", "Garbage",
                "Garbage", "Garbage", "Garbage", "Garbage"};
        return binList;
    }

    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (materialSearchView.isSearchOpen()) {
            materialSearchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }
}
