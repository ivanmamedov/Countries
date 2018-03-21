package com.example.student.countries.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.student.countries.R;
import com.example.student.countries.classes.Country;
import com.example.student.countries.classes.Place;

import java.util.ArrayList;


public class PlacesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<Place> list;

    public PlacesAdapter(Context context, ArrayList<Place> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = new View(context);
        switch (viewType) {
            case 1:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place1, parent, false);
                break;
            case 2:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place2, parent, false);
                break;
            case 3:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place3, parent, false);
                break;

        }
        return new PlaceHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Place obj = list.get(position);
        switch (obj.getType()) {
            case 1:
                ((PlaceHolder) holder).tvCountry.setText(obj.getCountry());
                ((PlaceHolder) holder).tvTitle.setText(obj.getTitle());
                Glide.with(context).load(obj.getImages().get(0)).thumbnail(0.5f).into(((PlaceHolder) holder).imageView);

                ((PlaceHolder) holder).cv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                break;
            case 2:
                ((PlaceHolder) holder).tvCountry.setText(obj.getCountry());
                ((PlaceHolder) holder).tvTitle.setText(obj.getTitle());
                Glide.with(context).load(obj.getImages().get(0)).thumbnail(0.5f).into(((PlaceHolder) holder).imageView);
                Glide.with(context).load(obj.getImages().get(1)).thumbnail(0.5f).into(((PlaceHolder) holder).imageView1);

                ((PlaceHolder) holder).cv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                break;
            case 3:
                ((PlaceHolder) holder).tvCountry.setText(obj.getCountry());
                ((PlaceHolder) holder).tvTitle.setText(obj.getTitle());
                Glide.with(context).load(obj.getImages().get(0)).thumbnail(0.5f).into(((PlaceHolder) holder).imageView);
                Glide.with(context).load(obj.getImages().get(1)).thumbnail(0.5f).into(((PlaceHolder) holder).imageView1);
                Glide.with(context).load(obj.getImages().get(2)).thumbnail(0.5f).into(((PlaceHolder) holder).imageView2);

                ((PlaceHolder) holder).cv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                break;

        }

    }

    @Override
    public int getItemViewType(int position) {

        return list.get(position).getType();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class PlaceHolder extends RecyclerView.ViewHolder {
        private final CardView cv;
        private final TextView tvCountry;
        private final TextView tvTitle;
        private final ImageView imageView;
        private final ImageView imageView1;
        private final ImageView imageView2;

        public PlaceHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            tvCountry = itemView.findViewById(R.id.tv_country);
            tvTitle = itemView.findViewById(R.id.tv_title);
            imageView = itemView.findViewById(R.id.imageView);
            imageView1 = itemView.findViewById(R.id.imageView1);
            imageView2 = itemView.findViewById(R.id.imageView2);
        }
    }
}
