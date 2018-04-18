package com.example.student.countries.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.example.student.countries.activities.MainActivity;

/**
 * Created by Ivan on 18.04.2018.
 */

public class Settings {
    SharedPreferences preferences;
    final static String COUNTER_PREFERENCES = "counter";

    public static void clickCounter(Context context){

        SharedPreferences sharedPref = ((AppCompatActivity) context).getPreferences(Context.MODE_PRIVATE);

        int highScore = sharedPref.getInt(COUNTER_PREFERENCES, 0);

        highScore++;
        if (highScore == 5) {
            ((MainActivity) context).showInterstitial();
            highScore = 0;
        }
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(COUNTER_PREFERENCES, highScore);
        editor.commit();
    }
}
