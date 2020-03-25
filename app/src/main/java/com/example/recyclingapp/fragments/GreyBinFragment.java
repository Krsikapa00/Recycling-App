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
//Hard coded dontent for page
        titleList.add("Acceptable Items");
        titleList.add("Keep Out");
        titleList.add("Important");

        contentList.add("\u0009\u0009\u0009• Newspapers, flyers, junk mail, \n\u0009\u0009\u0009 envelopes, magazines, and \n\u0009\u0009\u0009 telephone books \n" +
                "\u0009\u0009\u0009• Boxboard such as cereal and crackers \n\u0009\u0009\u0009 boxes (liners removed), paper egg \n\u0009\u0009\u0009 cartons and drink trays, toilet paper and \n\u0009\u0009\u0009 paper towel tubes \n" +
                "\u0009\u0009\u0009• Paper carton such as milk and juice \n\u0009\u0009\u0009 cartons, Tetra Pak containers and juice \n\u0009\u0009\u0009 boxes, paper coffee cups (lids removed \n\u0009\u0009\u0009 and place in blue box) \n" +
                "\u0009\u0009\u0009• Books (hardcover removed) \n" +
                "\u0009\u0009\u0009• Stretchable plastic bags \n" +
                "\u0009\u0009\u0009• Cardboard: \n" +
                "\u0009\u0009\u0009\u0009\u0009\u0009\u0009o Remove staples, tape, and plastic \n\u0009\u0009\u0009\u0009\u0009\u0009\u0009 outer wrap and flatten \n" +
                "\u0009\u0009\u0009\u0009\u0009\u0009\u0009o Put out pieces and bundles (tied  \n\u0009\u0009\u0009\u0009\u0009\u0009\u0009 with string) no bigger than 90 cm x \n\u0009\u0009\u0009\u0009\u0009\u0009\u0009 60 cm x 20 cm ");
        contentList.add("\u0009\u0009\u0009• Gift wrap \n" +
                "\u0009\u0009\u0009• Wax-coated boxes and greasy pizza \n\u0009\u0009\u0009 boxes (these go in the green bin) \n" +
                "\u0009\u0009\u0009• Cereal and cracker box liners, \n\u0009\u0009\u0009 zipper-style plastic bags, pet food bags, \n\u0009\u0009\u0009 bubble wrap and plastic food wrap ");
        contentList.add("\u0009\u0009\u0009• Make sure all appropriate items are \n\u0009\u0009\u0009 rinsed clean \n" +
                "\u0009\u0009\u0009• There is a 20 kg (44 lbs) weight limit for \n\u0009\u0009\u0009 the blue bins and their content \n" +
                "\u0009\u0009\u0009• You may put papers inside an untied \n\u0009\u0009\u0009 plastic bag to prevent blowing litter \n" +
                "\u0009\u0009\u0009• Shredded paper must be placed in a \n\u0009\u0009\u0009 clear, tied bag no larger than 90cm x \n\u0009\u0009\u0009 60cm x 20 cm \n" +
                "\u0009\u0009\u0009• Please keep boxboard and cardboard \n\u0009\u0009\u0009 separated ");


        GuideAdapter guideAdapter = new GuideAdapter(mCtx, R.layout.adapter_guide_layout, titleList, contentList, pictureList);
        recyclerView.setAdapter(guideAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mCtx));
        return v;
    }
}
