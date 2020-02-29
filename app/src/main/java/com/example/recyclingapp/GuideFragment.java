package com.example.recyclingapp;

import android.app.ActionBar;
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
    private ActionBar toolbar;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_guide, container,false);

        Context mCtx = getActivity().getApplicationContext();


         navigation = v.findViewById(R.id.guide_nav_view);
         navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        return v;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()){
                case R.id.bottomnav_compost:
                    getFragmentManager().beginTransaction().replace(R.id.guide_fragment_container, new CompostFragment()).commit();
                    break;
                case R.id.bottomnav_garbage:
                    getFragmentManager().beginTransaction().replace(R.id.guide_fragment_container, new GarbageFragment()).commit();
                    break;
                case R.id.bottomnav_recycling:
                    getFragmentManager().beginTransaction().replace(R.id.guide_fragment_container, new RecyclingFragment()).commit();
                    break;
                case R.id.bottomnav_special:
                    getFragmentManager().beginTransaction().replace(R.id.guide_fragment_container, new OtherItemsFragment()).commit();
                    break;
            }
            return false;
        }
    };
}
