package com.example.recyclingapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.recyclingapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GuideFragment extends Fragment {

    @Nullable
    private BottomNavigationView navigation;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_guide, container, false);

        //Default starting screen for this page
        Fragment startingFragment = new BlueBinFragment();
        int startingFragmentId = R.id.bottomnav_bluebin;

        Bundle bundle = this.getArguments();

        //Changes the starting bin shown depending on what the user chooses to get here
        if (bundle != null) {
            String selectedBin = bundle.getString("BinId", "Blue Bin");
            if (selectedBin.equals("Green Bin")){
                startingFragment = new GreenBinFragment();
                startingFragmentId = R.id.bottomnav_greenbin;
            }
            else if (selectedBin.equals("Blue Bin")){
                startingFragment = new BlueBinFragment();
                startingFragmentId = R.id.bottomnav_bluebin;
            }
            else if (selectedBin.equals("Grey Bin")){
                startingFragment = new GreyBinFragment();
                startingFragmentId = R.id.bottomnav_greybin;
            }
            else if (selectedBin.equals("Garbage")){
                startingFragment = new GarbageFragment();
                startingFragmentId = R.id.bottomnav_garbage;
            }
            else if (selectedBin.equals("Special")){
                startingFragment = new OtherItemsFragment();
                startingFragmentId = R.id.bottomnav_special;
            }
        }

        //assigns the bottom navigation to this variable
        navigation = v.findViewById(R.id.guide_nav_view);
        //Sets the navigations on click listener
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //Starting screen page
        getFragmentManager().beginTransaction().replace(R.id.guide_fragment_container, startingFragment).commit();
        navigation.setSelectedItemId(startingFragmentId);

        return v;
    }

    //Onclick listener for the bottom navigation
    //Displays the bin that was selected
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.bottomnav_greenbin:
                            selectedFragment = new GreenBinFragment();
                            break;
                        case R.id.bottomnav_garbage:
                            selectedFragment = new GarbageFragment();
                            break;
                        case R.id.bottomnav_bluebin:
                            selectedFragment = new BlueBinFragment();
                            break;
                        case R.id.bottomnav_special:
                            selectedFragment = new OtherItemsFragment();
                            break;
                        case R.id.bottomnav_greybin:
                            selectedFragment = new GreyBinFragment();
                            break;
                    }
                    assert getFragmentManager() != null;
                    getFragmentManager().beginTransaction().replace(R.id.guide_fragment_container, selectedFragment).commit();
                    return true;
                }
            };
}
