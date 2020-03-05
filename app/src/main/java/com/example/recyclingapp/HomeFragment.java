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

public class HomeFragment extends Fragment {
    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_home, container, false);
        Context mCtx = getActivity().getApplicationContext();
        RecyclerView recyclerView = v.findViewById(R.id.home_pickupdates_listview);

//TEMPORARY HARD CODED VALUES FOR THE COLLECTION DAYS (WILL LIKELY LEAVE UNLESS TIME TO TRANSFER TO FIREBASE)
        ArrayList<String> bins1 = new ArrayList<>();
        bins1.add("Blue Bin");bins1.add("Green Bin");bins1.add("Garbage");
        ArrayList<String> bins2 = new ArrayList<>();
        bins2.add("Grey Bin");bins2.add("Green Bin");bins2.add("Garbage");

        CollectionDatesClass date1 = new CollectionDatesClass("Monday April 6, 2020", bins1);
        CollectionDatesClass date2 = new CollectionDatesClass("Monday April 13, 2020", bins2);
        CollectionDatesClass date3 = new CollectionDatesClass("Monday April 20, 2020", bins1);
        CollectionDatesClass date4 = new CollectionDatesClass("Monday April 27, 2020", bins2);
        CollectionDatesClass date5 = new CollectionDatesClass("Monday May 4, 2020", bins1);
        CollectionDatesClass date6 = new CollectionDatesClass("Monday May 11, 2020", bins2);
        CollectionDatesClass date7 = new CollectionDatesClass("Monday May 18, 2020", bins1);
        CollectionDatesClass date8 = new CollectionDatesClass("Monday May 25, 2020", bins2);
        CollectionDatesClass date9 = new CollectionDatesClass("Monday June 1, 2020", bins1);
        CollectionDatesClass date0 = new CollectionDatesClass("Monday June 8, 2020", bins2);
        CollectionDatesClass date10 = new CollectionDatesClass("Monday June 15, 2020", bins1);
        CollectionDatesClass date11 = new CollectionDatesClass("Monday June 22, 2020", bins2);
        CollectionDatesClass date12 = new CollectionDatesClass("Monday June 29, 2020", bins1);
        //END OF TEMPORARY DATA CREATED LIST THAT WILL BE PASSED TO RECYCLER BELOW
        //REUSE SAME LIST HOWEVER PULL INFORMATION FROM FIREBASE IF POSSIBLE

        ArrayList<CollectionDatesClass> CollectionList = new ArrayList<>();
        CollectionList.add(date1);CollectionList.add(date2);CollectionList.add(date3);
        CollectionList.add(date4);CollectionList.add(date5);CollectionList.add(date6);
        CollectionList.add(date7);CollectionList.add(date8);CollectionList.add(date9);
        CollectionList.add(date0);CollectionList.add(date10);CollectionList.add(date11);
        CollectionList.add(date12);

        //Assigns the adapter the custom layout for each collection date view and the overall list of all views
        CollectionDatesAdapter collectionDatesAdapter = new CollectionDatesAdapter(mCtx, R.layout.adapter_collectiondates_layout,CollectionList);
        //Pushes it to the recyclerView
        recyclerView.setAdapter(collectionDatesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mCtx));

//        //Temporary data and code that will be removed and replaced with database
//        ItemClass item = new ItemClass("Paper","Recycling");
//        ItemClass item1 = new ItemClass("Food","Compost");
//        ItemClass item2 = new ItemClass("Tin foil","Garbage");
//        ItemClass item3 = new ItemClass("Paint","Hazard");
//        ItemClass item4 = new ItemClass("Cardboard","Recycling");
//        ItemClass item5 = new ItemClass("Food","Compost");
//        ItemClass item6 = new ItemClass("Garbage","Garbage");
//        ItemClass item7 = new ItemClass("Batteries","Hazard");
//        ItemClass item8= new ItemClass("Paper","Recycling");
//        ItemClass item9 = new ItemClass("Food","Compost");
//        ItemClass item0 = new ItemClass("Garbage","Garbage");
//        ItemClass item11 = new ItemClass("Batteries","Hazard");
//        ItemClass item12 = new ItemClass("Paper","Recycling");
//        ItemClass item13 = new ItemClass("Food","Compost");
//        ItemClass item14 = new ItemClass("Garbage","Garbage");
//        ItemClass item15 = new ItemClass("Batteries","Hazard");
//        ItemClass item16 = new ItemClass("Paper","Recycling");
//        ItemClass item17 = new ItemClass("Food","Compost");
//        ItemClass item18 = new ItemClass("Garbage","Garbage");
//        ItemClass item19 = new ItemClass("Batteries","Hazard");
//
//        ArrayList<ItemClass> overallList = new ArrayList<>();
//
//        overallList.add(item1);overallList.add(item11);
//        overallList.add(item2);overallList.add(item12);
//        overallList.add(item3);overallList.add(item14);
//        overallList.add(item4);overallList.add(item15);
//        overallList.add(item5);overallList.add(item16);
//        overallList.add(item6);overallList.add(item17);
//        overallList.add(item7);overallList.add(item18);
//        overallList.add(item8);overallList.add(item19);
//        overallList.add(item9);overallList.add(item13);
//        overallList.add(item0);overallList.add(item);


        //Should have one master list from the database and constantly filtering new lists from there?
        //OR for every list pull the items from the database?
        //Ex: Displayedlist, filtered by search, filtered by bin...
//        ArrayList<ItemClass> displayedList = overallList;


        //Filtering down the list of items
        //USE ADAPTER.FILTER
        //Find the search bar component
//        MaterialSearchView materialSearchView = v.findViewById(R.id.home_searchcomponent);
//        materialSearchView.closeSearch();
//        materialSearchView.setSuggestions(list);
//        materialSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });




        return v;
    }
}
