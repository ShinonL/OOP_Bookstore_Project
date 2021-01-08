package com.book.demo.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Country {
    private int id;
    private String name;
    private Collection<City> citiesById;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id == country.id &&
                Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "countryByCountryId")
    public Collection<City> getCitiesById() {
        return citiesById;
    }

    public void setCitiesById(Collection<City> citiesById) {
        this.citiesById = citiesById;
    }
}
