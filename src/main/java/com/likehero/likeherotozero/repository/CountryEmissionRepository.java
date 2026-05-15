package com.likehero.likeherotozero.repository;

import com.likehero.likeherotozero.model.CountryEmission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryEmissionRepository extends JpaRepository<CountryEmission, Long> {

   List<CountryEmission> findByCountry(String country);
}