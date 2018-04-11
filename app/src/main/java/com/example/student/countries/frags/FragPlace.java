package com.example.student.countries.frags;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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


        imagePager.setAdapter(new CustomPagerAdapter(getActivity()));
        //imagePager.setAdapter(new ImagePagerAdapter(getActivity().getSupportFragmentManager()));
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


    class CustomPagerAdapter extends PagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;

        public CustomPagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return place.getImages().size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.place_pager_item, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.placePagerImage);
           // imageView.setImageResource(mResources[position]);
            Glide.with(rootView.getContext()).load(place.getImages().get(position)).thumbnail(0.5f).into(imageView);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }
}
