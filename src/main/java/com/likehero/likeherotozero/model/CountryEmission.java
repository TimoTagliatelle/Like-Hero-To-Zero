package com.likehero.likeherotozero.model;

import jakarta.persistence.*;

@Entity
public class CountryEmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    private int year;

    private double co2Emission;

    public CountryEmission() {
    }

    public CountryEmission(String country, int year, double co2Emission) {
        this.country = country;
        this.year = year;
        this.co2Emission = co2Emission;
    }

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCo2Emission() {
        return co2Emission;
    }

    public void setCo2Emission(double co2Emission) {
        this.co2Emission = co2Emission;
    }
}