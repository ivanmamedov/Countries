package com.example.student.countries.classes;

import java.io.Serializable;
import java.util.Comparator;


public class Country implements Serializable {
    String continent;
    String currency;
    String detailsInfo;
    String flagUrl;
    String mainCity;
    String name;
    Long population;
    double square;
    String telCod;
    String isoCod;
    String domen;
    String numbercode;
    String coatUrl;

    final String BASE_URL = "http://geo.koltyrin.ru/";

    public Country(String continent, String currency, String detailsInfo, String flagUrl, String mainCity, String name, Long population, double square, String telCod, String isoCod, String domen, String numbercode, String coatUrl) {
        this.continent = continent;
        this.currency = currency;
        this.detailsInfo = detailsInfo;
        this.flagUrl = BASE_URL + flagUrl;
        this.mainCity = mainCity;
        this.name = name;
        this.population = population;
        this.square = square;
        this.telCod = telCod;
        this.isoCod = isoCod;
        this.domen = domen;
        this.numbercode = numbercode;
        this.coatUrl = BASE_URL + coatUrl;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDetailsInfo() {
        return detailsInfo;
    }

    public void setDetailsInfo(String detailsInfo) {
        this.detailsInfo = detailsInfo;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }

    public String getMainCity() {
        return mainCity;
    }

    public void setMainCity(String mainCity) {
        this.mainCity = mainCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public String getTelCod() {
        return telCod;
    }

    public void setTelCod(String telCod) {
        this.telCod = telCod;
    }

    public String getIsoCod() {
        return isoCod;
    }

    public void setIsoCod(String isoCod) {
        this.isoCod = isoCod;
    }

    public String getDomen() {
        return domen;
    }

    public void setDomen(String domen) {
        this.domen = domen;
    }

    public String getNumbercode() {
        return numbercode;
    }

    public void setNumbercode(String numbercode) {
        this.numbercode = numbercode;
    }

    public String getCoatUrl() {
        return coatUrl;
    }

    public void setCoatUrl(String coatUrl) {
        this.coatUrl = coatUrl;
    }


    public static final Comparator<Country> nameComparator = new Comparator<Country>() {
        @Override
        public int compare(Country o1, Country o2) {
            String name1 = o1.getName().toUpperCase();
            String name2 = o2.getName().toUpperCase();
            return name1.compareTo(name2);
        }
    };
}
