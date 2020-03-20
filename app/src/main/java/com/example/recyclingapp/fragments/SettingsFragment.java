package com.example.recyclingapp.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.recyclingapp.R;

public class SettingsFragment extends Fragment {

    @Nullable
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "collection date";


    Button saveBtn;
    RadioGroup collectionGroup;
    RadioButton mondayRBtn;
    RadioButton tuesdayRBtn;
    RadioButton wednesdayRBtn;
    RadioButton thursdayRBtn;
    RadioButton fridayRBtn;
    int savedChoice;
    ImageView mapImg;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);


        saveBtn = v.findViewById(R.id.settings_button_save);
        collectionGroup = v.findViewById(R.id.settings_option_group);
        mondayRBtn = v.findViewById(R.id.settings_option_monday);
        tuesdayRBtn = v.findViewById(R.id.settings_option_tuesday);
        wednesdayRBtn = v.findViewById(R.id.settings_option_wednesday);
        thursdayRBtn = v.findViewById(R.id.settings_option_thursday);
        fridayRBtn = v.findViewById(R.id.settings_option_friday);

        //Need to update picture in the map to pull the saved option AND check the selected day
        mapImg = v.findViewById(R.id.settings_map_image);

        collectionGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkRBtn = group.findViewById(checkedId);

                if (checkRBtn.isChecked()){
                    setMapImg(checkedId);
                }
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedDate = findCheckedRadioBtn();
                saveData(checkedDate);
            }
        });

        loadData(v);

        return v;
    }

    public void saveData(int checkedDate) {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(TEXT, checkedDate );
        editor.apply();
    }

    public void loadData(View v){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
            savedChoice = sharedPreferences.getInt(TEXT, -1);
            if (savedChoice != -1 ){
                RadioButton setBtn;
                setBtn = v.findViewById(savedChoice);
                if (setBtn != null){
                    if (!setBtn.isChecked())
                        setBtn.toggle();
                }
            }
    }

    public int findCheckedRadioBtn(){
        if (mondayRBtn.isChecked())
            return R.id.settings_option_monday;
        else if (tuesdayRBtn.isChecked())
            return R.id.settings_option_tuesday;
        else if (wednesdayRBtn.isChecked())
            return R.id.settings_option_wednesday;
        else if (thursdayRBtn.isChecked())
            return R.id.settings_option_thursday;
        else if (fridayRBtn.isChecked())
            return R.id.settings_option_friday;
        //Default day is Monday
        else
            return R.id.settings_option_monday;
    }

    private void setMapImg(int checkedId) {
        int image = R.drawable.monday_collection;
        if (checkedId == R.id.settings_option_monday)
            image = R.drawable.monday_collection;
        else if (checkedId == R.id.settings_option_tuesday)
            image = R.drawable.tuesday_collection;
        else if (checkedId == R.id.settings_option_wednesday)
            image = R.drawable.wednesday_collection;
        else if (checkedId == R.id.settings_option_thursday)
            image = R.drawable.thursday_collection;
        else if (checkedId == R.id.settings_option_friday)
            image = R.drawable.friday_collection;
        mapImg.setImageResource(image);

    }


}
