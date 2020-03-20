package com.example.recyclingapp.adapters;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclingapp.R;

import java.util.ArrayList;

public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.MyViewHolder> {

    private Context mContext;
    private int mResource;
    private ArrayList<Integer> mPicture;

    private ArrayList<String> mTitles;
    private ArrayList<String> mContent;

    public GuideAdapter(Context context, int resource, ArrayList<String> titles, ArrayList<String> content, ArrayList<Integer> picture ) {
        mContext = context;
        mResource = resource;
        mTitles = titles;
        mContent = content;
        mPicture = picture;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titleView;
        TextView contentView;
        ImageView imageView;


        public MyViewHolder(View itemView) {
            super(itemView);
            //Sets variables to the views used in the adapter layout
            contentView = itemView.findViewById(R.id.adapter_resources_content);
            titleView = itemView.findViewById(R.id.adapter_resources_title);
            imageView = itemView.findViewById(R.id.adapter_resources_image);

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
        String title = mTitles.get(position);
        String content = mContent.get(position);

        if (mPicture.get(0) != -1){
            int image = mPicture.get(position);
            holder.imageView.setImageResource(image);
        }

        SpannableString spannableString = new SpannableString(title);
        spannableString.setSpan(new UnderlineSpan(), 0,title.length(),0);

        //Sets the date of the view
        holder.contentView.setText(content);
        holder.titleView.setText(spannableString);
    }

    @Override
    public int getItemCount() {
        return mTitles.size();
    }
}