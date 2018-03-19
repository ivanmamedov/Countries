package com.example.student.countries.frags;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.countries.R;


public class FragInfo extends Fragment {


    View rootView;
    public static FragInfo instance;

    public FragInfo() {
    }
    public static FragInfo getInstance(String param1, String param2) {
        if (instance != null){
            return instance;
        }
        else {
            instance = new FragInfo();
            return  instance;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frag_countries, container, false);
        return rootView;
    }

}
