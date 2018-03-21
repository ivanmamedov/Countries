package com.example.student.countries.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ivan on 21.02.2018.
 */

public class Place implements Serializable {
    String title;
    String country;
    String continent;
    String article;
    ArrayList<String> images;
    int type;

    public Place(String title, String country, String continent, String article, ArrayList<String> images) {
        this.title = title;
        this.country = country;
        this.continent = continent;
        this.article = article;
        this.images = images;

        Random r = new Random();
        type = r.nextInt(3) + 1;
    }

    public String getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }
}
