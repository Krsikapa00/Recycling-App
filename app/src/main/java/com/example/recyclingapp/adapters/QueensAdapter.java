package com.example.recyclingapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclingapp.R;

import java.util.ArrayList;

public class QueensAdapter extends RecyclerView.Adapter<QueensAdapter.MyViewHolder> {

    private Context mContext;
    private int mResource;
    private ArrayList<String> locationList;
    private ArrayList<String> vendorList;
    private OnItemListener mOnItemListener;

    public QueensAdapter(Context context, int resource, ArrayList<String> vendors, ArrayList<String> location, OnItemListener onItemListener) {
        mContext = context;
        mResource = resource;
        locationList = location;
        vendorList = vendors;
        mOnItemListener = onItemListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView locationView;
        TextView vendorView;
        LinearLayout overallLayout;
        OnItemListener onItemListener;

        public MyViewHolder(View itemView, OnItemListener onItemListener) {
            super(itemView);
            //Sets variables to the views used in the adapter layout
            vendorView = itemView.findViewById(R.id.adapter_queens_vendor);
            locationView = itemView.findViewById(R.id.adapter_queens_location);
            overallLayout = itemView.findViewById(R.id.adapter_queens_layout);
            this.onItemListener = onItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemListener(getAdapterPosition());
        }
    }
    public interface OnItemListener{
        void onItemListener(int position);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(mResource, parent, false);
        return new MyViewHolder(view, mOnItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String vendor = vendorList.get(position);
        String location = locationList.get(position);

        //Sets the date of the view
        holder.vendorView.setText(vendor);
        holder.locationView.setText(location);
    }

    @Override
    public int getItemCount() {
        return vendorList.size();
    }
}