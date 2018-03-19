package com.example.student.countries.utils;

import com.example.student.countries.classes.Country;
import com.example.student.countries.classes.Place;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

import static com.example.student.countries.classes.Country.nameComparator;

/**
 * Created by Ivan on 21.02.2018.
 */

public class JsonParser {


    public static ArrayList<Country> parseCountryList(String strJson) {
        ArrayList<Country> listCountries = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(strJson);
            JSONArray jsonArray = jsonObject.getJSONArray("list");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);

                listCountries.add(new Country(obj.getString("continent"),
                        obj.getString("currency"),
                        obj.getString("detailsInfo"),
                        obj.getString("flagUrl"),
                        obj.getString("mainCity"),
                        obj.getString("name"),
                        obj.getLong("population"),
                        obj.getDouble("square"),
                        obj.getString("telCod"),
                        obj.getString("isoCod"),
                        obj.getString("domen"),
                        obj.getString("numbercode"),
                        obj.getString("coatUrl")
                ));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Collections.sort(listCountries, nameComparator);
        return listCountries;
    }

    public static ArrayList<Place> parsePlaceList(String strJson) {
        ArrayList<Place> listPlaces = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(strJson);
            JSONArray jsonArray = jsonObject.getJSONArray("articles");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                ArrayList<String> images = new ArrayList<>();
                JSONArray imgs = obj.getJSONArray("images");
                for (int j = 0; j < imgs.length(); j++) {
                    images.add(imgs.getString(j));
                }

                listPlaces.add(new Place(obj.getString("title"),
                        obj.getString("country"),
                        obj.getString("continent"),
                        obj.getString("article"),
                        images
                ));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        Collections.shuffle(listPlaces);
        return listPlaces;
    }


}
