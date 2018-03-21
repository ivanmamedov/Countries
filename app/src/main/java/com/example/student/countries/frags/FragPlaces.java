package com.example.student.countries.frags;

import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.countries.R;
import com.example.student.countries.adapters.CountriesAdapter;
import com.example.student.countries.adapters.PlacesAdapter;
import com.example.student.countries.classes.Country;
import com.example.student.countries.classes.Place;
import com.example.student.countries.utils.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class FragPlaces extends Fragment {

    View rootView;
    public static FragPlaces instance;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    PlacesAdapter countriesAdapter;

    public FragPlaces() {
    }

    public static FragPlaces newInstance() {
        return new FragPlaces();
    }

    public static FragPlaces getInstance() {
        if (instance != null){
            return instance;
        }
        else {
            instance = newInstance();
            return  instance;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frag_places, container, false);

        recyclerView = rootView.findViewById(R.id.rv);
        swipeRefreshLayout = rootView.findViewById(R.id.swipe);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setData();
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), OrientationHelper.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        setData();
        return rootView;
    }

    public void setData(){
        new LoadData().execute();
    }


    private class LoadData extends AsyncTask<Void, Void, ArrayList<Place>>{

        @Override
        protected ArrayList<Place> doInBackground(Void... voids) {
            String text = "";
            ArrayList<Place> list = new ArrayList<>();
            try{
                InputStream inputStream = getActivity().getAssets().open("places2.json");
                int size = inputStream.available();
                byte[] buffer = new byte[size];
                inputStream.read(buffer);
                inputStream.close();
                text = new String(buffer);
                list = JsonParser.parsePlaceList(text);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return list;
        }

        @Override
        protected void onPostExecute(ArrayList<Place> places) {
            super.onPostExecute(places);

            swipeRefreshLayout.setRefreshing(false);
            countriesAdapter = new PlacesAdapter(getActivity(), places);
            recyclerView.setAdapter(countriesAdapter);

        }
    }

}
