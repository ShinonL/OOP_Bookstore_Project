package com.book.demo.Repositories;

import com.book.demo.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country findCountryByName(String name);
}
