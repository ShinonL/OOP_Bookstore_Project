package com.book.demo.Entities;

import javax.persistence.*;
import java.util.Collection;

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

        if (id != genre1.id) return false;
        if (genre != null ? !genre.equals(genre1.genre) : genre1.genre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "genreByGenreId")
    public Collection<BookGenre> getBookGenresById() {
        return bookGenresById;
    }

    public void setBookGenresById(Collection<BookGenre> bookGenresById) {
        this.bookGenresById = bookGenresById;
    }
}
