package com.book.demo.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Genre {
    private int id;
    private String genre;
    private Collection<BookGenre> bookGenresById;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Genre", nullable = false, length = 30)
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre1 = (Genre) o;
        return id == genre1.id &&
                Objects.equals(genre, genre1.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genre);
    }

    @OneToMany(mappedBy = "genreByGenreId")
    public Collection<BookGenre> getBookGenresById() {
        return bookGenresById;
    }

    public void setBookGenresById(Collection<BookGenre> bookGenresById) {
        this.bookGenresById = bookGenresById;
    }
}
