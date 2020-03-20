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

public class GreenBinFragment extends Fragment {
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

        titleList.add("Acceptable Items");
        titleList.add("Keep Out");
        titleList.add("Important");
        titleList.add("Acceptable Liners");
        titleList.add("Non-Acceptable Liners");

        contentList.add("\u0009\u0009\u0009• All food scraps and leftovers, including fruit and vegetables; tea bags and coffee grounds; meat, poultry, bones, fish and shellfish; dairy products, butter and margarine; bread, baked goods, rice, pasta and cereals; gravy and sauces; eggs and eggshells \n" +
                "\u0009\u0009\u0009• Used facial tissues, paper towels, greasy pizza boxes, microwavable popcorn bags, paper plates and paper napkins \n" +
                "\u0009\u0009\u0009• Coffee filters, grounds, and tea bags \n" +
                "\u0009\u0009\u0009• Dryer lint, hair, and sawdust \n" +
                "\u0009\u0009\u0009• Yard waste such as leaves, weeds, and household plants ");
        contentList.add("\u0009\u0009\u0009• Plastic and oxo-biodegradable grocery bags, pet litter, pet waste, diapers, feminine hygiene products, dryer sheets, cotton balls and swabs, disposable dusters and sweeper cloths, gravel, stones and dirt ");
        contentList.add("\u0009\u0009\u0009• Place organic waste loosely in your green bin or use papers liners, such as brown bags or sheets of newspaper (certified compostable bags are also acceptable liners) \n" +
                "\u0009\u0009\u0009• Collectors must see food waste in the green bin in order to pick it up, but you may include some yard waste as long as food waste is visible ");
        contentList.add("\u0009\u0009\u0009• BPI-certified compostable liner bags \n" +
                "\u0009\u0009\u0009• Cellulose-lined paper food waste bags or paper yard waste bags \n" +
                "\u0009\u0009\u0009• Sheets of newspaper, paper towels, or microwave popcorn bags ");
        contentList.add("\u0009\u0009\u0009• Plastic shopping or grocery bags \n" +
                "\u0009\u0009\u0009• Oxo-biodegradable shopping bags \n" +
                "\u0009\u0009\u0009• Pet waste bags ");

        GuideAdapter guideAdapter = new GuideAdapter(mCtx, R.layout.adapter_guide_layout, titleList, contentList, pictureList);
        recyclerView.setAdapter(guideAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mCtx));
        return v;
    }
}
