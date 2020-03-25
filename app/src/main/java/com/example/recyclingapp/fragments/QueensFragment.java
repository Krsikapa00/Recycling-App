package com.example.recyclingapp.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclingapp.R;
import com.example.recyclingapp.adapters.ItemsAdapter;
import com.example.recyclingapp.adapters.QueensAdapter;

import java.util.ArrayList;

public class QueensFragment extends Fragment implements QueensAdapter.OnItemListener {

    View v;
    Context mCtx;
    public static ArrayList<String> vendorList;
    ArrayList<String> locationList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.fragment_queens, container,false);
        mCtx = getActivity().getApplicationContext();
        RecyclerView recyclerView = v.findViewById(R.id.queens_recyclerview);
        //Hard coded dontent for page
        //HARDCODED DATA FOR DINING HALLS AND THEIR LOCATIONS
        vendorList = new ArrayList<>();
        locationList = new ArrayList<>();
        vendorList.add("Location 21");locationList.add("David C. Smith House");
        vendorList.add("The Lazy Scholar");locationList.add("Victoria Hall");
        vendorList.add("The Canadian Grilling Company");locationList.add("Mackintosh-Corry Hall");
        vendorList.add("Pita Pit");locationList.add("Mackintosh-Corry Hall, ARC");
        vendorList.add("Starbucks");locationList.add("Mitchell Hall, Goodes Hall");
        vendorList.add("Tim Hortons");locationList.add("ARC, Biosciences Complex");
        vendorList.add("Gord's Cafe");locationList.add("Gord-Brock House ");
        vendorList.add("Teriyaki Experience");locationList.add("ARC");
        vendorList.add("Booster Juice");locationList.add("ARC");
        vendorList.add("Common Grounds");locationList.add("ARC");
        vendorList.add("Pizza Pizza");locationList.add("ARC");
        vendorList.add("Khao");locationList.add("JDUC");
        vendorList.add("Market Street");locationList.add("Botterell Hall");
        vendorList.add("Goodes Cafe");locationList.add("Goodes Hall");
        vendorList.add("The Library Cafe");locationList.add("Stauffer library");
        vendorList.add("Quiznos");locationList.add("JDUC");

        //Assigns the adapter the custom layout for each collection date view and the overall list of all views
        QueensAdapter queensAdapter = new QueensAdapter(mCtx,R.layout.adapter_queens_layout, vendorList,locationList, this);
        //Pushes it to the recyclerView
        recyclerView.setAdapter(queensAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mCtx));
        return v;
    }
    
    @Override
    //on Click listener which displays the items when specific vendor is clicked
    public void onItemListener(int position) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.alert_dialog_vendors, null);
        RecyclerView vendorRecyclerView = view.findViewById(R.id.alert_vendor_commonitemlist);
        TextView vendortitle = view.findViewById(R.id.alert_vendor_header);
        vendortitle.setText(vendorList.get(position));

        ItemsAdapter itemsAdapter = new ItemsAdapter(mCtx, R.layout.adapter_item_layout,vendorList.get(position));
        vendorRecyclerView.setAdapter(itemsAdapter);
        vendorRecyclerView.setLayoutManager(new LinearLayoutManager(mCtx));
        Button closeBtn = view.findViewById(R.id.alert_vendor_closebtn);

        final AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setView(view)
                .create();
        alertDialog.show();
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });
    }
}
