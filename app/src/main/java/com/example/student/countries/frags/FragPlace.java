package com.example.student.countries.frags;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.countries.R;


public class FragPlace extends Fragment {

    View rootView;
    public static FragPlace instance;



    public FragPlace() {
    }

    public static FragPlace newInstance() {
        FragPlace fragment = new FragPlace();
        return fragment;
    }

    public static FragPlace getInstance() {
        /*FragCountries fragment = new FragCountries();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;*/
        if (instance != null){
            return instance;
        }
        else {
            instance = newInstance();
            return  instance;
        }

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frag_countries, container, false);

        return rootView;

    }




}
