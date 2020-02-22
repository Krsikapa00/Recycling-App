package com.example.recyclingapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class SearchFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_search, container,false);

        Context mCtx = getActivity().getApplicationContext();

        //Temporary data and code that will be removed and replaced with database
        ItemClass item = new ItemClass("Paper","Recycling");
        ItemClass item1 = new ItemClass("Food","Compost");
        ItemClass item2 = new ItemClass("Garbage","Garbage");
        ItemClass item3 = new ItemClass("Batteries","Hazard");
        ItemClass item4 = new ItemClass("Paper","Recycling");
        ItemClass item5 = new ItemClass("Food","Compost");
        ItemClass item6 = new ItemClass("Garbage","Garbage");
        ItemClass item7 = new ItemClass("Batteries","Hazard");
        ItemClass item8= new ItemClass("Paper","Recycling");
        ItemClass item9 = new ItemClass("Food","Compost");
        ItemClass item0 = new ItemClass("Garbage","Garbage");
        ItemClass item11 = new ItemClass("Batteries","Hazard");
        ItemClass item12 = new ItemClass("Paper","Recycling");
        ItemClass item13 = new ItemClass("Food","Compost");
        ItemClass item14 = new ItemClass("Garbage","Garbage");
        ItemClass item15 = new ItemClass("Batteries","Hazard");
        ItemClass item16 = new ItemClass("Paper","Recycling");
        ItemClass item17 = new ItemClass("Food","Compost");
        ItemClass item18 = new ItemClass("Garbage","Garbage");
        ItemClass item19 = new ItemClass("Batteries","Hazard");

        ArrayList<ItemClass> itemList = new ArrayList<>();
        itemList.add(item1);itemList.add(item11);
        itemList.add(item2);itemList.add(item12);
        itemList.add(item3);itemList.add(item14);
        itemList.add(item4);itemList.add(item15);
        itemList.add(item5);itemList.add(item16);
        itemList.add(item6);itemList.add(item17);
        itemList.add(item7);itemList.add(item18);
        itemList.add(item8);itemList.add(item19);
        itemList.add(item9);itemList.add(item13);
        itemList.add(item0);itemList.add(item);

        //Lines above will be replaced when database is introduced


        //separate the overall list of items by the bottom navigation item selected

        View searchView = v.findViewById(R.id.search_searchbar).findViewById(R.id.component_searchbar);

        //3: set filtered list to adapter and inform adapter of change.



        ItemListAdapter adapter = new ItemListAdapter(mCtx , R.layout.adapter_item_layout, itemList);

        ListView mListView = v.findViewById(R.id.search_listview);

        mListView.setAdapter(adapter);

        return v;

    }

    //1: Create function for process since all will be the same

//    public ArrayList<ItemClass> FilterList (ArrayList<ItemClass> overallList, String binType) {
//
//        ArrayList<ItemClass> outputArray = new ArrayList<>();
//
//        for (int i = 0; i < overallList.size(); i++){
//            ItemClass currIndex = overallList.get(i);
//
//            if (currIndex.Bin == binType) {
//                outputArray.add(currIndex);
//            }
//
//        }
//        return outputArray;
//    }


    //2: function should take in the overall list of items and what bin to filter by and return af iltered list

}
