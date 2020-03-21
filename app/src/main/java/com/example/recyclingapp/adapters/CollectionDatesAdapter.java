package com.example.recyclingapp.adapters;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclingapp.fragments.GuideFragment;
import com.example.recyclingapp.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;
import static com.example.recyclingapp.MainActivity.SetCheckedMenuItem;

public class CollectionDatesAdapter extends RecyclerView.Adapter<CollectionDatesAdapter.MyViewHolder> {

    private Context mContext;
    private int mResource;
    private ArrayList<String> itemList;
    private FragmentManager mFragmentManager;

    public CollectionDatesAdapter(Context context, int resource, String date, FragmentManager fragmentManager) {
        mContext = context;
        mResource = resource;
        itemList = getCollectionDatesList(date);
        mFragmentManager = fragmentManager;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView collectionDate;
        LinearLayout binBtnLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            //Sets variables to the views used in the adapter layout
            collectionDate = itemView.findViewById(R.id.adapter_collectiondate);
            binBtnLayout = itemView.findViewById(R.id.adapter_collectionBtnLayout);
        }
    }

    @NonNull
    @Override
    //Displays the list of collection dates in the specified view
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(mResource, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String date = itemList.get(position);
        ArrayList<String> bins = getBinTypeList(position);
        Log.i(TAG, "onBindViewHolder: "+date);
        //Sets the date of the view
        holder.collectionDate.setText(date);
        LinearLayout btnLayout = holder.binBtnLayout;

        //Added this if statement because without it the for loop was ran multiple times
        //Causing layout to have multiple buttons
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
        layoutParams.setMargins(5, 0, 5, 0);
        if (btnLayout.getChildCount() == 0) {
            //Creates buttons for each bin on that pick up date based on the list provided
            for (int i = 0; i < 3; i++) {
                //SET DIMENSIONS AND TEXT FOR EACH BTN
                final Button binBtn = new Button(mContext);
                binBtn.setLayoutParams(layoutParams);
                binBtn.setText(bins.get(i));
                binBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Fragment Binfragment = new GuideFragment();
                        Bundle arguments = new Bundle();
                        arguments.putString("BinId", binBtn.getText().toString());
                        Binfragment.setArguments(arguments);

                        //changes fragment to the Guide page and sets the guide page to go to the specific bin clicked
                        mFragmentManager.beginTransaction().replace(R.id.fragment_container, Binfragment).commit();
                        //Changes the selected menuitem on the drawer to the guide
                        SetCheckedMenuItem(R.id.nav_guide);
                    }
                });
                btnLayout.addView(binBtn);
            }
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public ArrayList<String> getBinTypeList(int position) {
        ArrayList<String> bins1 = new ArrayList<>();
        if (position % 2 == 0) {
            bins1.add("Blue Bin");
            bins1.add("Green Bin");
            bins1.add("Garbage");
        } else {
            bins1.add("Grey Bin");
            bins1.add("Green Bin");
            bins1.add("Garbage");
        }
        return bins1;
    }

    public ArrayList<String> getCollectionDatesList(String date) {
        //Fill with list of collection dates
        ArrayList<String> collectionDates = new ArrayList<>();

        if (date.equals("Monday")) {
            collectionDates.add("Monday April 13, 2020");
            collectionDates.add("Monday April 20, 2020");
            collectionDates.add("Monday April 27, 2020");
            collectionDates.add("Monday May 4, 2020");
            collectionDates.add("Monday May 11, 2020");
            collectionDates.add("Monday May 18, 2020");
            collectionDates.add("Monday May 25, 2020");
            collectionDates.add("Monday June 1, 2020");
            collectionDates.add("Monday June 8, 2020");
            collectionDates.add("Monday June 15, 2020");
            collectionDates.add("Monday June 22, 2020");
            collectionDates.add("Monday June 29, 2020");
            return collectionDates;
        } else if (date.equals("Tuesday")) {
            collectionDates.add("Tuesday April 14, 2020");
            collectionDates.add("Tuesday April 21, 2020");
            collectionDates.add("Tuesday April 28, 2020");
            collectionDates.add("Tuesday May 5, 2020");
            collectionDates.add("Tuesday May 12, 2020");
            collectionDates.add("Tuesday May 19, 2020");
            collectionDates.add("Tuesday May 26, 2020");
            collectionDates.add("Tuesday June 2, 2020");
            collectionDates.add("Tuesday June 9, 2020");
            collectionDates.add("Tuesday June 16, 2020");
            collectionDates.add("Tuesday June 23, 2020");
            collectionDates.add("Tuesday June 30, 2020");
            return collectionDates;
        } else if (date.equals("Wednesday")) {
            collectionDates.add("Wednesday April 15, 2020");
            collectionDates.add("Wednesday April 22, 2020");
            collectionDates.add("Wednesday April 29, 2020");
            collectionDates.add("Wednesday May 6, 2020");
            collectionDates.add("Wednesday May 13, 2020");
            collectionDates.add("Wednesday May 20, 2020");
            collectionDates.add("Wednesday May 27, 2020");
            collectionDates.add("Wednesday June 3, 2020");
            collectionDates.add("Wednesday June 10, 2020");
            collectionDates.add("Wednesday June 17, 2020");
            collectionDates.add("Wednesday June 24, 2020");
            collectionDates.add("Wednesday July 1, 2020");
            return collectionDates;
        } else if (date.equals("Thursday")) {
            collectionDates.add("Thursday April 16, 2020");
            collectionDates.add("Thursday April 23, 2020");
            collectionDates.add("Thursday April 30, 2020");
            collectionDates.add("Thursday May 7, 2020");
            collectionDates.add("Thursday May 14, 2020");
            collectionDates.add("Thursday May 21, 2020");
            collectionDates.add("Thursday May 28, 2020");
            collectionDates.add("Thursday June 4, 2020");
            collectionDates.add("Thursday June 11, 2020");
            collectionDates.add("Thursday June 18, 2020");
            collectionDates.add("Thursday June 25, 2020");
            collectionDates.add("Thursday July 2, 2020");
            return collectionDates;
        } else {
            collectionDates.add("Friday April 17, 2020");
            collectionDates.add("Friday April 24, 2020");
            collectionDates.add("Friday May 1, 2020");
            collectionDates.add("Friday May 8, 2020");
            collectionDates.add("Friday May 15, 2020");
            collectionDates.add("Friday May 22, 2020");
            collectionDates.add("Friday May 29, 2020");
            collectionDates.add("Friday June 5, 2020");
            collectionDates.add("Friday June 12, 2020");
            collectionDates.add("Friday June 19, 2020");
            collectionDates.add("Friday June 26, 2020");
            collectionDates.add("Friday July 3, 2020");
            return collectionDates;
        }
    }
}

