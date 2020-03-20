package com.example.recyclingapp.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclingapp.R;
import com.example.recyclingapp.adapters.CollectionDatesAdapter;

public class HomeFragment extends Fragment {
    View v;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "collection date";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_home, container, false);
        Context mCtx = getActivity().getApplicationContext();
        RecyclerView recyclerView = v.findViewById(R.id.home_pickupdates_listview);
        String collectionDate = getCollectionDate();

        CollectionDatesAdapter collectionDatesAdapter = new CollectionDatesAdapter(mCtx, R.layout.adapter_collectiondates_layout, collectionDate, getActivity().getSupportFragmentManager());
        //Pushes it to the recyclerView
        recyclerView.setAdapter(collectionDatesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mCtx));
        return v;
    }

    public String getCollectionDate(){
//        Reads data saved on the phone and sets the collection date chosen
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        int savedChoice = sharedPreferences.getInt(TEXT, -1);
        if (savedChoice == R.id.settings_option_monday)
            return "Monday";
        else if (savedChoice == R.id.settings_option_tuesday)
            return "Tuesday";
        else if (savedChoice == R.id.settings_option_wednesday)
            return "Wednesday";
        else if (savedChoice == R.id.settings_option_thursday)
            return "Thursday";
        else if (savedChoice == R.id.settings_option_friday)
            return "Friday";
        else
            return "Monday";
    }
}
