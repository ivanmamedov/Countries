package com.example.student.countries.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.student.countries.R;
import com.example.student.countries.activities.MainActivity;
import com.example.student.countries.classes.Country;
import com.example.student.countries.frags.FragCountries;
import com.example.student.countries.frags.FragPager;

import java.util.ArrayList;



public class CountriesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<Country> list;

    public CountriesAdapter (Context context, ArrayList<Country> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new CountryHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final Country obj = list.get(position);
        ((CountryHolder) holder).tvCountry.setText(obj.getName());
        ((CountryHolder) holder).tvContinent.setText(obj.getContinent());
        Glide.with(context).load(obj.getFlagUrl()).thumbnail(0.5f).into(((CountryHolder) holder).imageView);

        ((CountryHolder) holder).cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("identificator", "country");
                bundle.putInt("position", position);
                FragPager fragPager = FragPager.getInstance();
                fragPager.setArguments(bundle);
                FragmentManager fm = ((MainActivity) context).getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.content, fragPager);
                ft.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CountryHolder extends RecyclerView.ViewHolder {
        private final CardView cv;
        private final TextView tvCountry;
        private final TextView tvContinent;
        private final ImageView imageView;
        public CountryHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            tvCountry = itemView.findViewById(R.id.tv_country);
            tvContinent = itemView.findViewById(R.id.tv_continent);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
