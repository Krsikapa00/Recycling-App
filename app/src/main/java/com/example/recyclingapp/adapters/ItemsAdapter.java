package com.example.recyclingapp.adapters;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclingapp.ItemClass;
import com.example.recyclingapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.MyViewHolder> {

    private Context mContext;
    private int mResource;
    private String mVendorFilter;
    private ArrayList<ItemClass> itemList;

    public ItemsAdapter(Context context, int resource, String vendorFilter) {
        mContext = context;
        mResource = resource;
        mVendorFilter = vendorFilter;
        itemList = getItemList(mVendorFilter);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        TextView itemBin;
        LinearLayout layout;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.adapter_itemname);
            itemBin = itemView.findViewById(R.id.adapter_itembin);
            layout = itemView.findViewById(R.id.adapter_itemlayout);
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
        //Gets name and bin from list
        String name = itemList.get(position).getName();
        String bin = itemList.get(position).getBin();

        SpannableString underlinedName = new SpannableString(name);
        underlinedName.setSpan(new UnderlineSpan(),0,name.length(),0);
        holder.itemName.setText(underlinedName);
        holder.itemBin.setText(bin);

        //Alters background based on the bin type
        if (bin.equals("Blue Bin"))
            holder.layout.setBackgroundColor(mContext.getResources().getColor(R.color.blueBin));
        else if (bin.equals("Green Bin"))
            holder.layout.setBackgroundColor(mContext.getResources().getColor(R.color.greenBin));
        else if (bin.equals("Garbage"))
            holder.layout.setBackgroundColor(mContext.getResources().getColor(R.color.Garbage));
        else if (bin.equals("Grey Bin"))
            holder.layout.setBackgroundColor(mContext.getResources().getColor(R.color.greyBin));
        else if (bin.equals("Hazard")) {
            holder.layout.setBackgroundColor(mContext.getResources().getColor(R.color.Hazard));
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    //Creates list of vendors and common items among each vendor Hard coded data. Ideally would be put into a database to save space
    public ArrayList<ItemClass> getItemList(String filter) {
        ArrayList<ItemClass> overallList = new ArrayList<>();
        ArrayList<ItemClass> filteredList;

        String loco, lazy, cgc, cogro, starbucks, pitaPit, tims, gords, teriyaki, boost, pizza, khao, mStreet, goodes, libCafe, quiznos, teaRoom, all ;
        loco = "Location 21"; boost ="Booster Juice"; teaRoom = "The Tea Room";
        lazy = "The Lazy Scholar"; pizza = "Pizza Pizza"; all = "all";
        cgc = "The Canadian Grilling Company"; khao = "Khao";
        cogro = "Common Grounds"; mStreet = "Market Street";
        pitaPit = "Pita Pit"; goodes = "Goodes Cafe";
        starbucks = "Starbucks"; libCafe = "The Library Cafe";
        tims = "Tim Hortons"; quiznos = "Quiznos";
        gords = "Gord's Cafe"; teriyaki = "Teriyaki Experience";

        ItemClass item1 = new ItemClass("Aluminum foil", "Blue Bin", Collections.singletonList(lazy)); overallList.add(item1);
        ItemClass item2 = new ItemClass("Smoothie cup", "Garbage", Collections.singletonList(boost)); overallList.add(item2);
        ItemClass item3 = new ItemClass("Plastic container bowl", "Blue Bin", Collections.singletonList(lazy)); overallList.add(item3);
        ItemClass item4 = new ItemClass("Plastic container lid", "Blue Bin", Collections.singletonList(lazy)); overallList.add(item4);
        ItemClass item5 = new ItemClass("Chip bags", "Garbage", Collections.singletonList(all)); overallList.add(item5);
        ItemClass item6 = new ItemClass("Coffee cup sleeves", "Grey Bin", Arrays.asList(teaRoom,tims,lazy, loco,starbucks,libCafe,gords,goodes,cogro, mStreet )); overallList.add(item6);
        ItemClass item7 = new ItemClass("Coffee lids", "Blue Bin", Arrays.asList(teaRoom,tims,lazy, loco,starbucks,libCafe,gords,goodes,cogro, mStreet )); overallList.add(item7);
        ItemClass item8 = new ItemClass("Coffee lids (Compostable)", "Green Bin", Arrays.asList(teaRoom,tims,lazy, loco,starbucks,libCafe,gords,goodes,cogro, mStreet )); overallList.add(item8);
        ItemClass item9 = new ItemClass("Common Grounds cups", "Green Bin", Collections.singletonList(cogro)); overallList.add(item9);
        ItemClass item10 = new ItemClass("Food waste", "Green Bin", Collections.singletonList(all)); overallList.add(item10);
        ItemClass item11 = new ItemClass("Fresh-to-go Salad Box", "Blue Bin", Arrays.asList(lazy, loco)); overallList.add(item11);
        ItemClass item12 = new ItemClass("Juice Boxes", "Grey Bin", Arrays.asList(lazy, loco)); overallList.add(item12);
        ItemClass item13 = new ItemClass("Khao to-go container", "Garbage", Collections.singletonList(khao)); overallList.add(item13);
        ItemClass item14 = new ItemClass("Food container", "Grey Bin", Arrays.asList(loco, lazy)); overallList.add(item14);
        ItemClass item15 = new ItemClass("Salad container", "Organics", Collections.singletonList(loco)); overallList.add(item15);
        ItemClass item16 = new ItemClass("Salad lid", "Blue Bin", Collections.singletonList(loco)); overallList.add(item16);
        ItemClass item17 = new ItemClass("Milk carton", "Grey Bin", Arrays.asList(lazy, loco)); overallList.add(item17);
        ItemClass item18 = new ItemClass("Muffin liners", "Green Bin", Arrays.asList(teaRoom,tims,lazy, loco,starbucks,libCafe,gords,goodes,cogro, mStreet )); overallList.add(item18);
        ItemClass item19 = new ItemClass("Napkins", "Green Bin", Collections.singletonList(all)); overallList.add(item19);
        ItemClass item20 = new ItemClass("Paper bag", "Grey Bin", Arrays.asList(tims, pizza, starbucks, gords,goodes, cogro, mStreet, libCafe)); overallList.add(item20);
        ItemClass item21 = new ItemClass("Paper coffee cups", "Grey Bin", Arrays.asList(teaRoom,tims,lazy, loco,starbucks,libCafe,gords,goodes,cogro, mStreet )); overallList.add(item21);
        ItemClass item22 = new ItemClass("Paper soda cup", "Blue Bin", Arrays.asList(loco, lazy)); overallList.add(item22);
        ItemClass item23 = new ItemClass("Paper straw", "Grey Bin", Arrays.asList(lazy, loco)); overallList.add(item23);
        ItemClass item24 = new ItemClass("Pita wrappers", "Green Bin", Arrays.asList(pitaPit, quiznos, lazy)); overallList.add(item24);
        ItemClass item25 = new ItemClass("Pizza boxes", "Grey Bin", Collections.singletonList(pizza)); overallList.add(item25);
        ItemClass item26 = new ItemClass("Pizza tray", "Grey Bin", Collections.singletonList(pizza)); overallList.add(item26);
        ItemClass item27 = new ItemClass("Plastic cutlery", "Garbage", Collections.singletonList(all)); overallList.add(item27);
        ItemClass item28 = new ItemClass("Plastic drinking cups", "Blue Bin", Arrays.asList(lazy, loco, tims, starbucks, teaRoom)); overallList.add(item28);
        ItemClass item29 = new ItemClass("Plastic Fresh-to-go snack boxes", "Blue Bin", Arrays.asList(loco, lazy )); overallList.add(item29);
        ItemClass item30 = new ItemClass("Plastic straws", "Garbage",Arrays.asList(teaRoom,tims,lazy, loco,starbucks,libCafe,gords,goodes,cogro, mStreet, quiznos )); overallList.add(item30);
        ItemClass item31 = new ItemClass("Plastic wrappers", "Garbage", Collections.singletonList(all)); overallList.add(item31);
        ItemClass item32 = new ItemClass("Plastic sushi boxes", "Blue Bin", Arrays.asList(khao, loco, teriyaki)); overallList.add(item32);
        ItemClass item33 = new ItemClass("Salt/Pepper packets", "Green Bin", Collections.singletonList(all)); overallList.add(item33);
        ItemClass item34 = new ItemClass("Sauce cups", "Green Bin", Collections.singletonList(all)); overallList.add(item34);
        ItemClass item35 = new ItemClass("Sauce packets", "Garbage", Collections.singletonList(all)); overallList.add(item35);
        ItemClass item36 = new ItemClass("Soda bottle", "Blue Bin", Collections.singletonList(all)); overallList.add(item36);
        ItemClass item37 = new ItemClass("Soda cup lid", "Blue Bin", Collections.singletonList(all)); overallList.add(item37);
        ItemClass item38 = new ItemClass("Compostable straws", "Green Bin", Collections.singletonList(starbucks)); overallList.add(item38);
        ItemClass item39 = new ItemClass("Straw wrapper (Paper)", "Grey Bin", Arrays.asList(boost,loco,lazy,tims, starbucks, quiznos)); overallList.add(item39);
        ItemClass item40 = new ItemClass("Takeout cardboard boxes", "Grey Bin", Collections.singletonList(teriyaki)); overallList.add(item40);
        ItemClass item41 = new ItemClass("Tea bags", "Green Bin", Arrays.asList(teaRoom,tims,lazy, loco,starbucks,libCafe,gords,goodes,cogro, mStreet )); overallList.add(item41);
        ItemClass item42 = new ItemClass("Tea Room plastic cups", "Green Bin", Collections.singletonList(teaRoom)); overallList.add(item42);
        ItemClass item43 = new ItemClass("Wax pastry bags", "Green Bin", Arrays.asList(teaRoom,tims,lazy, loco,starbucks,libCafe,gords,goodes,cogro, mStreet )); overallList.add(item43);
        ItemClass item44 = new ItemClass("Wooden chopsticks", "Green Bin", Arrays.asList(khao, teriyaki)); overallList.add(item44);
        ItemClass item45 = new ItemClass("Plastic bag", "Blue Bin", Arrays.asList(quiznos, pitaPit)); overallList.add(item45);

        filteredList = checkVendor(overallList, filter);
        Log.i(TAG, "getItemList:"+overallList.get(0).getName());
        return filteredList;
    }

    private ArrayList<ItemClass> checkVendor(ArrayList<ItemClass> overallList, String filter) {
        ArrayList<ItemClass> filteredList = new ArrayList<>();
        for (int i = 0; i < overallList.size(); i++){
            List<String> vendorList = overallList.get(i).getVendor();
            if (vendorList.contains("all"))
                filteredList.add(overallList.get(i));
            else if (vendorList.contains(filter))
                filteredList.add(overallList.get(i));
        }
        return filteredList;
    }
}
