package com.example.student.countries.classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ivan on 21.02.2018.
 */

public class Place implements Serializable {
    String title;
    String country;
    String continent;
    String article;
    ArrayList<String> images;

    public Place(String title, String country, String continent, String article, ArrayList<String> images) {
        this.title = title;
        this.country = country;
        this.continent = continent;
        this.article = article;
        this.images = images;
    }

    public String getTitle() {
        return title;
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
