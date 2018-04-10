package com.example.student.countries.frags;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.student.countries.R;
import com.example.student.countries.classes.Place;


public class FragPlace extends Fragment {

    View rootView;
    public static FragPlace instance;
    Place place;



    public FragPlace() {
    }

    public static FragPlace newInstance() {
        FragPlace fragment = new FragPlace();
        return fragment;
    }

    public static FragPlace getInstance() {
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
        rootView = inflater.inflate(R.layout.frag_place, container, false);

        if (getArguments() != null) {
            place = (Place) getArguments().getSerializable("place");
        }

        ViewPager imagePager = rootView.findViewById(R.id.placeImagePager);
        TextView title = rootView.findViewById(R.id.placeTitle);
        TextView country = rootView.findViewById(R.id.tvPlaceCountry);
        TextView continent = rootView.findViewById(R.id.tvPlaceContinent);
        TextView article = rootView.findViewById(R.id.placeArticle);

        title.setText(place.getTitle());
        country.setText(place.getCountry());
        continent.setText(place.getContinent());
        article.setText(place.getArticle());


        imagePager.setAdapter(new ImagePagerAdapter(getActivity().getSupportFragmentManager()));
        // create adapter and set it to the imagePager here

        return rootView;

    }
    class ImagePagerAdapter extends FragmentStatePagerAdapter {

        public ImagePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            ImagePagerItem fragment = new ImagePagerItem();
            Bundle bundle = new Bundle();
            bundle.putString("imageSrc", place.getImages().get(position));
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return place.getImages().size();
        }
    }
}
