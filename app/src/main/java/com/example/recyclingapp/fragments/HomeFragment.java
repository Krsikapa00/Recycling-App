package com.example.recyclingapp.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclingapp.R;
import com.example.recyclingapp.adapters.CollectionDatesAdapter;

import static com.example.recyclingapp.MainActivity.SetCheckedMenuItem;

public class HomeFragment extends Fragment {
    View v;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "collection date";
    TextView firstCollection;
    Button blueBtn;
    Button greenBtn;
    Button garbageBtn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_home, container, false);
        Context mCtx = getActivity().getApplicationContext();
        firstCollection = v.findViewById(R.id.adapter_nextcollectiontitle);
        blueBtn = v.findViewById(R.id.home_bluebtn);
        greenBtn = v.findViewById(R.id.home_greenbtn);
        garbageBtn = v.findViewById(R.id.home_garbagebtn);

        //Sends user to guide page depending on the bin clicked
        blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchScreen("Blue Bin");
            }
        });
        greenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchScreen("Green Bin");
            }
        });
        garbageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchScreen("Garbage");
            }
        });


        RecyclerView recyclerView = v.findViewById(R.id.home_pickupdates_listview);
        String collectionDate = getCollectionDate();

        //Builds the list of collections days
        CollectionDatesAdapter collectionDatesAdapter = new CollectionDatesAdapter(mCtx, R.layout.adapter_collectiondates_layout, collectionDate, getActivity().getSupportFragmentManager());
        //Pushes it to the recyclerView
        recyclerView.setAdapter(collectionDatesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mCtx));
        return v;
    }

    public String getCollectionDate() {
//        Reads data saved on the phone and sets the collection date chosen
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        int savedChoice = sharedPreferences.getInt(TEXT, -1);
        if (savedChoice == R.id.settings_option_monday) {
            firstCollection.setText("Monday April 6, 2020");
            return "Monday";
        } else if (savedChoice == R.id.settings_option_tuesday) {
            firstCollection.setText("Tuesday April 7, 2020");
            return "Tuesday";
        } else if (savedChoice == R.id.settings_option_wednesday) {
            firstCollection.setText("Wednesday April 8, 2020");
            return "Wednesday";
        } else if (savedChoice == R.id.settings_option_thursday) {
            firstCollection.setText("Thursday April 9, 2020");
            return "Thursday";
        } else if (savedChoice == R.id.settings_option_friday) {
            firstCollection.setText("Friday April 10, 2020");
            return "Friday";
        } else {
            firstCollection.setText("Monday April 6, 2020");
            return "Monday";
        }
    }

    //Passes the new screen along with bin information to switch screens with
    public void switchScreen(String bin){
        Fragment fragment = new GuideFragment();
        Bundle arguments = new Bundle();
        arguments.putString("BinId", bin);
        fragment.setArguments(arguments);

        getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment ).commit();
        SetCheckedMenuItem(R.id.nav_guide);

    }
}
