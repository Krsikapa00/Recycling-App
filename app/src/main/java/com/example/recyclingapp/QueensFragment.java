package com.example.recyclingapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QueensFragment extends Fragment {

    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.fragment_queens, container,false);
        Context mCtx = getActivity().getApplicationContext();
        RecyclerView recyclerView = v.findViewById(R.id.queens_recyclerview);

        //HARDCODED DATA FOR DINING HALLS AND THEIR LOCATIONS
        ArrayList<String> vendorList = new ArrayList<>();
        ArrayList<String> locationList = new ArrayList<>();
        vendorList.add("Location 21");locationList.add("David C. Smith House");
        vendorList.add("The Lazy Scholar");locationList.add("Victoria Hall");
        vendorList.add("The Canadian Grilling Company");locationList.add("Mackintosh-Corry Hall");
        vendorList.add("Pita Pit");locationList.add("Mackintosh-Corry Hall, ARC");
        vendorList.add("Starbucks");locationList.add("Mitchell Hall, Goodes Hall");
        vendorList.add("Tim Hortons");locationList.add("ARC, Biosciences Complex");
        vendorList.add("Gord's Cafe");locationList.add("Gord-Brock House ");
        vendorList.add("Teriaky Experience");locationList.add("ARC");
        vendorList.add("Booster Juice");locationList.add("ARC");
        vendorList.add("Common Grounds");locationList.add("ARC");
        vendorList.add("Pizza Pizza");locationList.add("ARC");
        vendorList.add("Khao");locationList.add("JDUC");
        vendorList.add("Market Street");locationList.add("Botterell Hall");
        vendorList.add("Goodes Cafe");locationList.add("Goodes Hall");
        vendorList.add("The Library Cafe");locationList.add("Stauffer library");
        vendorList.add("Quiznos");locationList.add("JDUC");

        //Assigns the adapter the custom layout for each collection date view and the overall list of all views
        QueensAdapter queensAdapter = new QueensAdapter(mCtx,R.layout.adapter_queens_layout, vendorList,locationList);
        //Pushes it to the recyclerView
        recyclerView.setAdapter(queensAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mCtx));




        return v;
    }
}
