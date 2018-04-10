package com.example.student.countries.frags;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.student.countries.R;

public class ImagePagerItem extends Fragment {

    View rootView;
    public static ImagePagerItem instance;
    ImageView image;

    public ImagePagerItem() {
    }
    public static ImagePagerItem getInstance() {
        if (instance != null) {
            return instance;
        } else {
            return new ImagePagerItem();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String imageSrc = "";
        if (getArguments() != null) {
            imageSrc = getArguments().getString("imageSrc");
        }
        rootView = inflater.inflate(R.layout.place_pager_item, container, false);

        image = rootView.findViewById(R.id.placePagerImage);
        Glide.with(rootView.getContext()).load(imageSrc).thumbnail(0.5f).into(image);

        return rootView;

    }
}