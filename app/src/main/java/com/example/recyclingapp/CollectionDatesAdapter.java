package com.example.recyclingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CollectionDatesAdapter extends RecyclerView.Adapter<CollectionDatesAdapter.MyViewHolder> {

    private Context mContext;
    private int mResource;
    private ArrayList<CollectionDatesClass> itemList;

    public CollectionDatesAdapter(Context context, int resource, ArrayList<CollectionDatesClass> objects) {
        mContext = context;
        mResource = resource;
        itemList = objects;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
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
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(mResource, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String date = itemList.get(position).getDate();
        ArrayList<String> bins = itemList.get(position).getBins();

        //Sets the date of the view
        holder.collectionDate.setText(date);
        LinearLayout btnLayout = holder.binBtnLayout;

        //Added this if statement because without it the for loop was ran multiple times
        //Causing layout to have multiple buttons
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT,1.0f);
        layoutParams.setMargins(5,0,5,0);
        if (btnLayout.getChildCount() == 0){
            //Creates buttons for each bin on that pick up date based on the list provided
            for (int i = 0; i< 3; i++){
                //SET DIMENSIONS AND TEXT FOR EACH BTN POSSIBLY ADD THE ONCLICK LISTENER HERE
                Button binBtn = new Button(mContext);
                binBtn.setLayoutParams(layoutParams);
                binBtn.setText(bins.get(i));


                //ADD ONCLICK LISTENER
                btnLayout.addView(binBtn);
            }
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
