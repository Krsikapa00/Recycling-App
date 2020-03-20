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

public class GarbageFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_guide_individual, container, false);

        Context mCtx = getActivity().getApplicationContext();
        RecyclerView recyclerView = v.findViewById(R.id.bluebin_recyclerview);


        ArrayList<String> titleList = new ArrayList<>();
        ArrayList<String> contentList = new ArrayList<>();
        ArrayList<Integer> pictureList = new ArrayList<>();
        pictureList.add(-1);

        titleList.add("Acceptable Items");titleList.add("Important");

        contentList.add("\u0009\u0009\u0009• Anything that cannot be diverted in the blue and grey boxes, green bin, or other \n" +
                "\u0009\u0009\u0009• Garbage goes straight to landfill (try and reduce your use of these items) \n" +
                "\u0009\u0009\u0009\u0009\u0009\u0009\u0009o Diapers, pet waste and litter \n" +
                "\u0009\u0009\u0009\u0009\u0009\u0009\u0009o Dryer sheet and vacuum bags \n" +
                "\u0009\u0009\u0009\u0009\u0009\u0009\u0009o Large plastic products such as lawn chairs or toys \n" +
                "\u0009\u0009\u0009\u0009\u0009\u0009\u0009o Hygiene products, gift wrap, and single use coffee pods \n" +
                "\u0009\u0009\u0009\u0009\u0009\u0009\u0009o Non-stretchy plastic bags ");
        contentList.add("\u0009\u0009\u0009• Broken glass and sharp objects should be placed in a cardboard box, taped shut, and labeled as broken glass \n" +
                "\u0009\u0009\u0009• There is a one untagged bag or container limit \n" +
                "\u0009\u0009\u0009• Extra tags can be purchased and must be visible by attaching them to the neck of garbage bags \n" +
                "\u0009\u0009\u0009• Bags and containers must weigh less than 20 kg (44 lbs) and be less than 135 L in capacity \n" +
                "\u0009\u0009\u0009• Excess bagged garbage and large garbage items can be disposed of at Waste connections of Canada, 1266 McAdoos Lane (call 613-548-4428 for hours of operation, charges, and accepted items) ");


        GuideAdapter guideAdapter = new GuideAdapter(mCtx, R.layout.adapter_guide_layout, titleList, contentList, pictureList);
        recyclerView.setAdapter(guideAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mCtx));
        return v;
    }
}