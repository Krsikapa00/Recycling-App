package com.example.recyclingapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclingapp.R;
import com.example.recyclingapp.adapters.GuideAdapter;

import java.util.ArrayList;

public class BlueBinFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_guide_individual, container,false);
        Context mCtx = getActivity().getApplicationContext();
        RecyclerView recyclerView = v.findViewById(R.id.bluebin_recyclerview);


        ArrayList<String> titleList = new ArrayList<>();
        ArrayList<String> contentList = new ArrayList<>();
        ArrayList<Integer> pictureList = new ArrayList<>();
        pictureList.add(-1);
        //Hard coded dontent for page
        titleList.add("Acceptable Items");titleList.add("Keep Out");titleList.add("Important");

        contentList.add("\u0009\u0009\u0009• Plastic food and beverage containers, \n\u0009\u0009\u0009 including bottles, jars, tubs, lids, \n\u0009\u0009\u0009 cartons, trays, and clamshells \n" +
                "\u0009\u0009\u0009• Rigid plastic packaging \n" +
                "\u0009\u0009\u0009• Aluminum and steel food and beverage \n\u0009\u0009\u0009 cans \n" +
                "\u0009\u0009\u0009• Paper cans with steel ends \n" +
                "\u0009\u0009\u0009• Glass food and beverage bottles and \n\u0009\u0009\u0009 jars (return beer and alcohol containers \n\u0009\u0009\u0009 to The Beer Store for a refund) \n" +
                "\u0009\u0009\u0009• Plain white Styrofoam packaging and \n\u0009\u0009\u0009 trays (no larger than 90 cm x 60 cm \n\u0009\u0009\u0009 x 20 cm) ");
        contentList.add("\u0009\u0009\u0009• Plastic products such as laundry \n\u0009\u0009\u0009 baskets, storage totes, toys, bubble \n\u0009\u0009\u0009 wrap, pet food bags, ten litre pails or \n\u0009\u0009\u0009 larger (plastic bags go in the grey box) \n" +
                "\u0009\u0009\u0009• Coloured or dyed Styrofoam (belongs in \n\u0009\u0009\u0009 garbage) \n" +
                "\u0009\u0009\u0009• Window glass, mirrors, light bulbs, \n\u0009\u0009\u0009 ceramic containers, and drinking glasses ");
        contentList.add("\u0009\u0009\u0009• Make sure all items are rinsed clean and \n\u0009\u0009\u0009 place them loosely in the blue bin (do \n\u0009\u0009\u0009 not bag blue bin items) \n" +
                "\u0009\u0009\u0009• There is a 20 kg (44 lbs) weight limit for \n\u0009\u0009\u0009 the blue bins and their content \n" +
                "\u0009\u0009\u0009• Be sure to check labeling for certain \n\u0009\u0009\u0009 plastic items that are compostable.");

        //Displays all information in a list
        GuideAdapter guideAdapter = new GuideAdapter(mCtx, R.layout.adapter_guide_layout, titleList, contentList, pictureList);
        recyclerView.setAdapter(guideAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mCtx));
        return v;

    }
}