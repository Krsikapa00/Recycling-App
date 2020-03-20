package com.example.recyclingapp;

import java.util.List;

public class ItemClass {
    String mName;
    String mBin;
    List<String> mVendor;


    public ItemClass(String name, String bin, List<String> vendor) {
        mName = name;
        mBin = bin;
        mVendor = vendor;
    }
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getBin() {
        return mBin;
    }

    public void setBin(String bin) {
        mBin = bin;
    }

    public void setVendor(List<String> vendor) {
        mVendor = vendor;
    }

    public List<String> getVendor() {
        return mVendor;
    }





}
