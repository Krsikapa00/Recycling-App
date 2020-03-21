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

public class OtherItemsFragment extends Fragment {
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

        titleList.add("Acceptable Hazardous Items");
        titleList.add("Non-Acceptable Hazardous Items");
        titleList.add("Important");
        titleList.add("Brush Week");
        titleList.add("Leaf Week");
        titleList.add("Electronic Waste and Tires");
        titleList.add("Giveaway Days");
        titleList.add("Acceptable Giveaway Days");
        titleList.add("Non-Acceptable Giveaway Days");

        contentList.add("\u0009\u0009\u0009• Aerosol containers and antifreeze \n" +
                "\u0009\u0009\u0009• Batteries \n" +
                "\u0009\u0009\u0009• Driveway sealer \n" +
                "\u0009\u0009\u0009• Fertilizer \n" +
                "\u0009\u0009\u0009• Fluorescent lights \n" +
                "\u0009\u0009\u0009• Gasoline, oil, and oil filters \n" +
                "\u0009\u0009\u0009• Paint, propane tanks, and solvents ");
        contentList.add("\u0009\u0009\u0009• Asbestos \n" +
                "\u0009\u0009\u0009• Incandescent light bulbs \n" +
                "\u0009\u0009\u0009• Smoke alarms ");
        contentList.add("\u0009\u0009\u0009• The household hazardous waste \n\u0009\u0009\u0009 drop-off is at the Kingston Area \n\u0009\u0009\u0009 Recycling Centre, 196 Lappan’s Lane \n\u0009\u0009\u0009 (please bring proof of residency) \n" +
                "\u0009\u0009\u0009• It is open April through November, \n\u0009\u0009\u0009 Thursdays, 8 a.m. to 5 p.m. and \n\u0009\u0009\u0009 Saturdays 8 a.m. to 4 p.m. \n" +
                "\u0009\u0009\u0009• To dispose of explosives, flares, or \n\u0009\u0009\u0009 ammunition, contact Kingston Police \n\u0009\u0009\u0009 for assistance ");
        contentList.add("\u0009\u0009\u0009• Brush collection takes place once a \n\u0009\u0009\u0009 year, starting in late September or \n\u0009\u0009\u0009 early October \n" +
                "\u0009\u0009\u0009• Please set out by 8 a.m. on the Monday \n\u0009\u0009\u0009 of your collection week \n" +
                "\u0009\u0009\u0009• Pieces must be 15 cm (6 in) or less in \n\u0009\u0009\u0009 diameter and less than 90 cm (3 feet) in \n\u0009\u0009\u0009 length \n" +
                "\u0009\u0009\u0009• Brush includes tree branches and bush \n\u0009\u0009\u0009 and shrub clippings \n" +
                "\u0009\u0009\u0009• Logs and root balls are not considered \n\u0009\u0009\u0009 brush and will not be collected \n" +
                "\u0009\u0009\u0009• Stack your brush at the curb with cut \n\u0009\u0009\u0009 ends facing the street (do not bundle) ");
        contentList.add("\u0009\u0009\u0009• Leaf collection takes place once a year, \n\u0009\u0009\u0009 starting in late October or early \n\u0009\u0009\u0009 November \n" +
                "\u0009\u0009\u0009• Please set out by 8 a.m. on the Monday \n\u0009\u0009\u0009 of your collection week \n" +
                "\u0009\u0009\u0009• Leaf waste can also include yard \n\u0009\u0009\u0009 wastes such as vegetable and garden \n\u0009\u0009\u0009 plants, flowers, and small twigs \n" +
                "\u0009\u0009\u0009• Leaf and yard waste can be placed in \n\u0009\u0009\u0009 brown paper yard waste bags or \n\u0009\u0009\u0009 rigid-sided, open top containers such as \n\u0009\u0009\u0009 garbage cans or bushel baskets \n" +
                "\u0009\u0009\u0009• There is a weight limit of 20 kg (44 lbs) \n\u0009\u0009\u0009 on bags and containers and their \n\u0009\u0009\u0009 contents. \n" +
                "\u0009\u0009\u0009• Do not put in plastic bags, these will not \n\u0009\u0009\u0009 be collected ");
        contentList.add("\u0009\u0009\u0009• Electronic waste can be disposed of for \n\u0009\u0009\u0009 free at numerous retailers throughout \n\u0009\u0009\u0009 Kingston such as Staples and Canada \n\u0009\u0009\u0009 Computers. \n" +
                "\u0009\u0009\u0009• Tires can be disposed of for free at \n\u0009\u0009\u0009 numerous retailers throughout \n\u0009\u0009\u0009 Kingston. ");
        contentList.add("\u0009\u0009\u0009• Use Giveaway Days to put out items you \n\u0009\u0009\u0009 no longer use for FREE pick-up by your \n\u0009\u0009\u0009 neighbours who might want them \n" +
                "\u0009\u0009\u0009• At the end of the day, bring back any \n\u0009\u0009\u0009 uncollected items (the City will NOT \n\u0009\u0009\u0009 collect these) \n" +
                "\u0009\u0009\u0009• Giveaway days in 2019 \n"+
                "\u0009\u0009\u0009\u0009\u0009\u0009\u0009o Saturday, April 6 \n" +
                "\u0009\u0009\u0009\u0009\u0009\u0009\u0009o Saturday, June 22 \n" +
                "\u0009\u0009\u0009\u0009\u0009\u0009\u0009o Saturday, August 17 \n" +
                "\u0009\u0009\u0009\u0009\u0009\u0009\u0009o Saturday, October 26 ");
        contentList.add("\u0009\u0009\u0009• Only set out items that you know \n\u0009\u0009\u0009 someone else might want \n" +
                "\u0009\u0009\u0009• Books, CDs, DVDs \n" +
                "\u0009\u0009\u0009• Furniture and small appliances \n" +
                "\u0009\u0009\u0009• Electronics \n" +
                "\u0009\u0009\u0009• Construction material \n" +
                "\u0009\u0009\u0009• Kitchen gadgets, dishes, cutlery, pots, \n\u0009\u0009\u0009 and pans ");
        contentList.add("\u0009\u0009\u0009• Baby walkers, cribs, car seats, strollers, \n\u0009\u0009\u0009 playpens \n" +
                "\u0009\u0009\u0009• Bath seats \n" +
                "\u0009\u0009\u0009• Mattresses \n" +
                "\u0009\u0009\u0009• Blinds \n" +
                "\u0009\u0009\u0009• Toys ");


        GuideAdapter guideAdapter = new GuideAdapter(mCtx, R.layout.adapter_guide_layout, titleList, contentList, pictureList);
        recyclerView.setAdapter(guideAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mCtx));

        return v;
    }
}