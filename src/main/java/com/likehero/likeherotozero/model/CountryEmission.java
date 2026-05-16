package com.likehero.likeherotozero.model;

import jakarta.persistence.*;

@Entity
public class CountryEmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    private Double co2Emission2022;
    private Double co2Emission2023;

    private boolean approved = false;

    public CountryEmission() {}

    public CountryEmission(String country, Double co2Emission2022, Double co2Emission2023) {
        this.country = country;
        this.co2Emission2022 = co2Emission2022;
        this.co2Emission2023 = co2Emission2023;
    }

    public Long getId() { return id; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Double getCo2Emission2022() { return co2Emission2022; }
    public void setCo2Emission2022(Double co2Emission2022) { this.co2Emission2022 = co2Emission2022; }

    public Double getCo2Emission2023() { return co2Emission2023; }
    public void setCo2Emission2023(Double co2Emission2023) { this.co2Emission2023 = co2Emission2023; }

    public boolean isApproved() {
    return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}