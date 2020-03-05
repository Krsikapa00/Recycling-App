package com.example.recyclingapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GuideFragment extends Fragment {

    @Nullable

    private BottomNavigationView navigation;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_guide, container, false);

        Context mCtx = getActivity().getApplicationContext();

        //assigns the bottom navigation to this variable
        navigation = v.findViewById(R.id.guide_nav_view);
        //Sets the navigations on click listener
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //Starting screen page
        getFragmentManager().beginTransaction().replace(R.id.guide_fragment_container, new BlueBinFragment()).commit();

        return v;
    }
//Onclick listener for the bottom navigation
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
