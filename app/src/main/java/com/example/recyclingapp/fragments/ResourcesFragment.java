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

public class ResourcesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_guide_individual, container, false);
        Context mCtx = getActivity().getApplicationContext();
        RecyclerView recyclerView = v.findViewById(R.id.bluebin_recyclerview);


        ArrayList<String> titleList = new ArrayList<>();
        ArrayList<String> contentList = new ArrayList<>();
        ArrayList<Integer> pictureList = new ArrayList<>();

        titleList.add("Recycling Council of Ontario (RCO)");
        titleList.add("Government of Ontario - Waste Management");
        titleList.add("Kingston Area Recycling Centre (KARC)");
        titleList.add("City of Kingston - Waste Managment");

        contentList.add("An organization made to inform and educate people about the waste generation, avoidance of waste, efficient uses of resources and benefits/consequences of these activities. RCO hosts events throughout the year to promote education of proper waste disposal and has on going programs and projects to help the generation of waste in Ontario. Check out their website link below to learn more about RCO and their mission or to join an upcoming event, project or program.");
        contentList.add("The government of Ontario’s website provides details on all programs and goals put in place by the Government. It also contains information on how to properly dispose of all types of items. Use the link below to see any updated programs or policies organized by the provincial Government.");
        contentList.add("The destination in Kingston for diversion options. The KARC has various programs to separate waste properly for the city. \n" +
                "\n" +
                "\u0009\u0009\u0009• Address: 196 Lappan's Lane, Kingston, \n\u0009\u0009\u0009ON, K7K 6Z4\n" +
                "\u0009\u0009\u0009• Email: contactus@cityofkingston.ca\n" +
                "\u0009\u0009\u0009• Phone: 613-546-0000\n" +
                "\u0009\u0009\u0009• Hours of Operation:\n" +
                "\u0009\u0009\u0009\u0009\u0009\u0009\u0009o Monday to Friday – 8:00 am to \n\u0009\u0009\u0009\u0009\u0009\u0009\u00095:00pm\n" +
                "\u0009\u0009\u0009\u0009\u0009\u0009\u0009o Saturday – 8:00 am to 4:00 pm\n");
        contentList.add("The city of Kingston website provides people with everything from updates about the waste disposal programs in Kingston to the weekly collection date schedule depending on your location and any tools you may need such as guides, garbage bag tags printable collection calendars. Use the link below to look at the site.");

        pictureList.add(R.drawable.rco_screenshot);
        pictureList.add(R.drawable.govontario_screenshot);
        pictureList.add(R.drawable.karc_screenshot);
        pictureList.add(R.drawable.kingston_waste_screenshot);

        GuideAdapter guideAdapter = new GuideAdapter(mCtx, R.layout.adapter_guide_layout, titleList, contentList, pictureList );
        recyclerView.setAdapter(guideAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mCtx));
        return v;
    }

}
