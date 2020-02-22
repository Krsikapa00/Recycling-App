package com.example.recyclingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemListAdapter extends ArrayAdapter<ItemClass> {
    private Context mContext;
    private int mResource;

    ItemListAdapter(Context context, int resource, ArrayList<ItemClass> objects) {
        super(context, resource, objects);
        this.mContext = context;
        mResource = resource;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {

        String name = getItem(position).getName();
        String bin = getItem(position).getBin();

//        ItemClass item = new ItemClass(name, bin);

        LayoutInflater inflater = LayoutInflater.from(mContext);

        //FIX figure out how to apply recycler view to the adapter
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName = convertView.findViewById(R.id.adapter_itemname);
        TextView tvBin = convertView.findViewById(R.id.adapter_itembin);
        LinearLayout lLayout = convertView.findViewById(R.id.adapter_itemlayout);

        tvBin.setText(bin);
        tvName.setText(name);


        //Changes colour of background depending on what bin
        //possibly add symbol for each bin as well
        if (bin.equals("Recycling"))
            lLayout.setBackgroundColor(mContext.getResources().getColor(R.color.recycling));
        else if (bin.equals("Compost"))
            lLayout.setBackgroundColor(mContext.getResources().getColor(R.color.Compost));
        else if (bin.equals("Garbage"))
            lLayout.setBackgroundColor(mContext.getResources().getColor(R.color.Garbage));
        else if (bin.equals("Hazard")) {
            lLayout.setBackgroundColor(mContext.getResources().getColor(R.color.Hazard));
//            tvName.setTextColor(mContext.getResources().getColor(R.color.white));
//            tvBin.setTextColor(mContext.getResources().getColor(R.color.white));
        }


        return convertView;
    }
}
