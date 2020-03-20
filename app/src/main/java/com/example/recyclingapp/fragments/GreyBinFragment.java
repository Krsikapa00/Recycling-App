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

public class GreyBinFragment extends Fragment {
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

        contentList.add("\u0009\u0009\u0009• Newspapers, flyers, junk mail, envelopes, magazines, and telephone books \n" +
                "\u0009\u0009\u0009• Boxboard such as cereal and crackers boxes (liners removed), paper egg cartons and drink trays, toilet paper and paper towel tubes \n" +
                "\u0009\u0009\u0009• Paper carton such as milk and juice cartons, Tetra Pak containers and juice boxes, paper coffee cups (lids removed and place in blue box) \n" +
                "\u0009\u0009\u0009• Books (hardcover removed) \n" +
                "\u0009\u0009\u0009• Stretchable plastic bags \n" +
                "\u0009\u0009\u0009• Cardboard: \n" +
                "\u0009\u0009\u0009\u0009\u0009\u0009\u0009o Remove staples, tape, and plastic outer wrap and flatten \n" +
                "\u0009\u0009\u0009\u0009\u0009\u0009\u0009o Put out pieces and bundles (tied with string) no bigger than 90 cm x 60 cm x 20 cm ");
        contentList.add("- Gift wrap \n" +
                "\u0009\u0009\u0009• Wax-coated boxes and greasy pizza boxes (these go in the green bin) \n" +
                "\u0009\u0009\u0009• Cereal and cracker box liners, zipper-style plastic bags, pet food bags, bubble wrap and plastic food wrap ");
        contentList.add("- Make sure all appropriate items are rinsed clean \n" +
                "\u0009\u0009\u0009• There is a 20 kg (44 lbs) weight limit for the blue bins and their content \n" +
                "\u0009\u0009\u0009• You may put papers inside an untied plastic bag to prevent blowing litter \n" +
                "\u0009\u0009\u0009• Shredded paper must be placed in a clear, tied bag no larger than 90cm x 60cm x 20 cm \n" +
                "\u0009\u0009\u0009• Please keep boxboard and cardboard separated ");


        GuideAdapter guideAdapter = new GuideAdapter(mCtx, R.layout.adapter_guide_layout, titleList, contentList, pictureList);
        recyclerView.setAdapter(guideAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mCtx));
        return v;
    }
}
