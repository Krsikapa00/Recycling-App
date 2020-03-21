package com.example.recyclingapp.fragments;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.recyclingapp.R;

public class AboutusFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_aboutus, container, false);

        TextView title = v.findViewById(R.id.aboutus_quest_title);
        TextView longTitle = v.findViewById(R.id.aboutus_quest_titlelong);

        SpannableString spannableTitle = new SpannableString("Q.U.E.S.T"); spannableTitle.setSpan(new UnderlineSpan(),0,spannableTitle.length(),0);
        SpannableString spannableLong = new SpannableString("Queen's University Experimental Sustainability Team");spannableLong.setSpan(new UnderlineSpan(),0,spannableLong.length(),0);
        title.setText(spannableTitle);
        longTitle.setText(spannableLong);
        return v;
    }
}
