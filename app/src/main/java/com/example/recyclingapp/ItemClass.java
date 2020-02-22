package com.example.recyclingapp;

public class ItemClass {
    String Name;
    String Bin;


    public ItemClass(String name, String bin) {
        Name = name;
        Bin = bin;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBin() {
        return Bin;
    }

    public void setBin(String bin) {
        Bin = bin;
    }


}
