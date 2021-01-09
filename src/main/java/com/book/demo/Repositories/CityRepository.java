package com.book.demo.Repositories;

import com.book.demo.Entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
    City findCityByName(String name);
}
