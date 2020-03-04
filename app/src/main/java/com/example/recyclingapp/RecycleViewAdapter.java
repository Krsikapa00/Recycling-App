package com.example.recyclingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    Context mContext;
    int mResource;
    ArrayList<ItemClass> itemList;

    public RecycleViewAdapter(Context context, int resource, ArrayList<ItemClass> objects) {
        mContext = context;
        mResource = resource;
        itemList = objects;
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
        //Gets name and bin from list
        String name = itemList.get(position).getName();
        String bin = itemList.get(position).getBin();

        holder.tvName.setText(name);
        holder.tvBin.setText(bin);

        //Alters background based on the bin type
        if (bin.equals("Recycling"))
            holder.layout.setBackgroundColor(mContext.getResources().getColor(R.color.recycling));
        else if (bin.equals("Compost"))
            holder.layout.setBackgroundColor(mContext.getResources().getColor(R.color.Compost));
        else if (bin.equals("Garbage"))
            holder.layout.setBackgroundColor(mContext.getResources().getColor(R.color.Garbage));
        else if (bin.equals("Hazard")) {
            holder.layout.setBackgroundColor(mContext.getResources().getColor(R.color.Hazard));
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvBin;
        LinearLayout layout;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.adapter_itemname);
            tvBin = itemView.findViewById(R.id.adapter_itembin);
            layout = itemView.findViewById(R.id.adapter_itemlayout);

        }

    }

//    @SuppressLint("ViewHolder")
//    @Override
//    public View getView(int position,View convertView, ViewGroup parent) {
//
//        String name = getItem(position).getName();
//        String bin = getItem(position).getBin();
//
//
//        LayoutInflater inflater = LayoutInflater.from(mContext);
//
//        //FIX figure out how to apply recycler view to the adapter
//        convertView = inflater.inflate(mResource, parent, false);
//
//        TextView tvName = convertView.findViewById(R.id.adapter_itemname);
//        TextView tvBin = convertView.findViewById(R.id.adapter_itembin);
//        LinearLayout lLayout = convertView.findViewById(R.id.adapter_itemlayout);
//
//        tvBin.setText(bin);
//        tvName.setText(name);
//
//        //Changes colour of background depending on what bin
//        //possibly add symbol for each bin as well
//        if (bin.equals("Recycling"))
//            lLayout.setBackgroundColor(mContext.getResources().getColor(R.color.recycling));
//        else if (bin.equals("Compost"))
//            lLayout.setBackgroundColor(mContext.getResources().getColor(R.color.Compost));
//        else if (bin.equals("Garbage"))
//            lLayout.setBackgroundColor(mContext.getResources().getColor(R.color.Garbage));
//        else if (bin.equals("Hazard")) {
//            lLayout.setBackgroundColor(mContext.getResources().getColor(R.color.Hazard));
////            tvName.setTextColor(mContext.getResources().getColor(R.color.white));
////            tvBin.setTextColor(mContext.getResources().getColor(R.color.white));
//        }
//
//
//        return convertView;
//    }


}
