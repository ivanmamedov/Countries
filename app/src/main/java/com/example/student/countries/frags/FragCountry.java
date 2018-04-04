package com.example.student.countries.frags;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.student.countries.R;
import com.example.student.countries.adapters.CountriesAdapter;
import com.example.student.countries.classes.Country;


public class FragCountry extends Fragment {
    View rootView;
    public static FragCountry instance;
    private TextView info;
    Country country;


    public FragCountry() {
    }

    public static FragCountry newInstance() {
        FragCountry fragment = new FragCountry();

        return fragment;
    }

    public static FragCountry getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = newInstance();
            return instance;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frag_country, container, false);

        //Bundle bundle = getInstance().getArguments();
        //Country country = (Country) bundle.getSerializable("country");
        if (getArguments() != null) {
            country = (Country) getArguments().getSerializable("country");
        }
        ImageView ivFlag  = rootView.findViewById(R.id.ivFlag);
        ImageView ivCoat  = rootView.findViewById(R.id.ivCoat);
        TextView tvCountryName  = rootView.findViewById(R.id.tvCountryName);
        TextView tvCurrency  = rootView.findViewById(R.id.tvCurrency);
        TextView tvPopulation  = rootView.findViewById(R.id.tvPopulation);
        TextView tvMainCity  = rootView.findViewById(R.id.tvMainCity);
        TextView tvContinent  = rootView.findViewById(R.id.tvContinent);
        TextView tvSquare  = rootView.findViewById(R.id.tvSquare);
        TextView tvTelCod  = rootView.findViewById(R.id.tvTelCod);
        TextView tvIsoCod  = rootView.findViewById(R.id.tvIsoCod);
        TextView tvDomen  = rootView.findViewById(R.id.tvDomen);
        TextView tvNumberCod  = rootView.findViewById(R.id.tvNumberCod);
        TextView tvInfo = rootView.findViewById(R.id.info);

        Glide.with(getActivity()).load(country.getFlagUrl()).thumbnail(0.5f).into(ivFlag);
        Glide.with(getActivity()).load(country.getCoatUrl()).thumbnail(0.5f).into(ivCoat);
        tvCountryName.setText(country.getName());
        tvCurrency.setText(country.getCurrency());
        tvPopulation.setText("" + country.getPopulation());
        tvMainCity.setText(country.getMainCity());
        tvContinent.setText(country.getContinent());
        tvSquare.setText("" + country.getSquare());
        tvTelCod.setText(country.getTelCod());
        tvIsoCod.setText(country.getIsoCod());
        tvDomen.setText(country.getDomen());
        tvNumberCod.setText(country.getNumbercode());

        tvInfo.setText(country.getDetailsInfo());

        return rootView;
    }
}
