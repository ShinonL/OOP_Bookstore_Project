package com.book.demo.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book_genre", schema = "bookstore", catalog = "")
public class BookGenre {
    private int id;
    private Book bookByIsbn;
    private Genre genreByGenreId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookGenre bookGenre = (BookGenre) o;
        return id == bookGenre.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "ISBN", referencedColumnName = "ISBN", nullable = false)
    public Book getBookByIsbn() {
        return bookByIsbn;
    }

    public void setBookByIsbn(Book bookByIsbn) {
        this.bookByIsbn = bookByIsbn;
    }

    @ManyToOne
    @JoinColumn(name = "Genre_ID", referencedColumnName = "ID", nullable = false)
    public Genre getGenreByGenreId() {
        return genreByGenreId;
    }

    public void setGenreByGenreId(Genre genreByGenreId) {
        this.genreByGenreId = genreByGenreId;
    }
}
