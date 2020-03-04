package com.example.recyclingapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_home, container,false);
        Context mCtx = getActivity().getApplicationContext();

//        Toolbar toolbar = v.findViewById(R.id.home_toolbar);



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


    //Fix function to connect with the onClickListener
    public ArrayList<ItemClass> FilterList(ArrayList<ItemClass> inputArray, String filter){
        ArrayList<ItemClass> filteredArray = new ArrayList<>();

        for (int i = 0; i< inputArray.size(); i++){
            if (filter == inputArray.get(i).Bin){
                filteredArray.add(inputArray.get(i));
            }
        }

        return filteredArray;
    }
}
