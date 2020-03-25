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
//Hard coded dontent for page
        contentList.add("\u0009\u0009\u0009• All food scraps and leftovers, including \n\u0009\u0009\u0009 fruit and vegetables; tea bags and coffee \n\u0009\u0009\u0009 grounds; meat, poultry, bones, fish and \n\u0009\u0009\u0009 shellfish; dairy products, butter and \n\u0009\u0009\u0009 margarine; bread, baked goods, rice, \n\u0009\u0009\u0009 pasta and cereals; gravy and sauces; \n\u0009\u0009\u0009 eggs and eggshells \n" +
                "\u0009\u0009\u0009• Used facial tissues, paper towels, \n\u0009\u0009\u0009 greasy pizza boxes, microwavable \n\u0009\u0009\u0009 popcorn bags, paper plates and paper \n\u0009\u0009\u0009 napkins \n" +
                "\u0009\u0009\u0009• Coffee filters, grounds, and tea bags \n" +
                "\u0009\u0009\u0009• Dryer lint, hair, and sawdust \n" +
                "\u0009\u0009\u0009• Yard waste such as leaves, weeds, and \n\u0009\u0009\u0009 household plants ");
        contentList.add("\u0009\u0009\u0009• Plastic and oxo-biodegradable grocery \n\u0009\u0009\u0009 bags, pet litter, pet waste, diapers, \n\u0009\u0009\u0009 feminine hygiene products, dryer sheets, \n\u0009\u0009\u0009 cotton balls and swabs, disposable \n\u0009\u0009\u0009 dusters and sweeper cloths, gravel, \n\u0009\u0009\u0009 stones and dirt ");
        contentList.add("\u0009\u0009\u0009• Place organic waste loosely in your \n\u0009\u0009\u0009 green bin or use papers liners, such as \n\u0009\u0009\u0009 brown bags or sheets of newspaper \n\u0009\u0009\u0009 (certified compostable bags are also \n\u0009\u0009\u0009 acceptable liners) \n" +
                "\u0009\u0009\u0009• Collectors must see food waste in the \n\u0009\u0009\u0009 green bin in order to pick it up, but you \n\u0009\u0009\u0009 may include some yard waste as long \n\u0009\u0009\u0009 as food waste is visible ");
        contentList.add("\u0009\u0009\u0009• BPI-certified compostable liner bags \n" +
                "\u0009\u0009\u0009• Cellulose-lined paper food waste bags \n\u0009\u0009\u0009 or paper yard waste bags \n" +
                "\u0009\u0009\u0009• Sheets of newspaper, paper towels, or \n\u0009\u0009\u0009 microwave popcorn bags ");
        contentList.add("\u0009\u0009\u0009• Plastic shopping or grocery bags \n" +
                "\u0009\u0009\u0009• Oxo-biodegradable shopping bags \n" +
                "\u0009\u0009\u0009• Pet waste bags ");

        GuideAdapter guideAdapter = new GuideAdapter(mCtx, R.layout.adapter_guide_layout, titleList, contentList, pictureList);
        recyclerView.setAdapter(guideAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mCtx));
        return v;
    }
}
