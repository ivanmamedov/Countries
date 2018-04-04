package com.example.student.countries.frags;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
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


public class FragPager extends Fragment {

    View rootView;
    public static FragPager instance;
    ViewPager viewPager;
    String identificator = "country";
    int position;
    ArrayList<Country> listCountries;
    ArrayList<Place> listPlaces;

    public FragPager() {
    }

    public static FragPager newInstance() {
        FragPager fragment = new FragPager();
        return fragment;
    }

    public static FragPager getInstance() {
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
        if (getArguments() != null) {
            identificator = getArguments().getString("identificator", "country");
            position = getArguments().getInt("position", 0);
        }
        rootView = inflater.inflate(R.layout.frag_pager, container, false);

        viewPager = rootView.findViewById(R.id.view_pager);


        new LoadCountries().execute();


        return rootView;

    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (identificator) {
                case "country":
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("country", listCountries.get(position));
                    Fragment fragment = new FragCountry();
                    fragment.setArguments(bundle);
                    return fragment;
                case "place":
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("place", listPlaces.get(position));
                    Fragment fragment1 = new FragCountry();
                    fragment1.setArguments(bundle1);
                    return fragment1;
                default: return null;
            }
        }

        @Override
        public int getCount() {
            switch (identificator) {
                case "country": return listCountries.size();
                case "place": return listPlaces.size();
                default: return 0;
            }

        }
    }

    private class LoadCountries extends AsyncTask<Void, Void, ArrayList<Country>> {

        @Override
        protected ArrayList<Country> doInBackground(Void... voids) {
            String text = "";
            ArrayList<Country> list = new ArrayList<>();
            try{
                InputStream inputStream = getActivity().getAssets().open("countries2.json");
                int size = inputStream.available();
                byte[] buffer = new byte[size];
                inputStream.read(buffer);
                inputStream.close();
                text = new String(buffer);
                list = JsonParser.parseCountryList(text);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return list;
        }

        @Override
        protected void onPostExecute(ArrayList<Country> countries) {
            super.onPostExecute(countries);

            listCountries = countries;
            MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getActivity().getSupportFragmentManager());
            viewPager.setAdapter(myPagerAdapter);
            viewPager.setCurrentItem(position);
        }
    }


    private class LoadPlaces extends AsyncTask<Void, Void, ArrayList<Place>>{

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

            listPlaces = places;
            MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getActivity().getSupportFragmentManager());
            viewPager.setAdapter(myPagerAdapter);
            viewPager.setCurrentItem(position);
        }
    }
}
