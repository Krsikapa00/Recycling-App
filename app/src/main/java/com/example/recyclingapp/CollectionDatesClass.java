package com.example.recyclingapp;

import java.util.ArrayList;

public class CollectionDatesClass {
    //Basic class set up to hold the information for each collection date.
    String Date;
    ArrayList<String> Bins;
    public CollectionDatesClass (String date, ArrayList<String> bins){
        Date = date;
        Bins = bins;
    }
    public String getDate() {
        return Date;
    }

    public void setDate(String name) {
        Date = name;
    }

    public ArrayList<String> getBins() {
        return Bins;
    }

    public void setBins(ArrayList<String> bin) {
        Bins = bin;
    }



}
