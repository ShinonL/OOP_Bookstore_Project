package com.book.demo.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book_authors", schema = "bookstore", catalog = "")
public class BookAuthors {
    private int id;
    private Book bookByIsbn;
    private Author authorByAuthorId;

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
        BookAuthors that = (BookAuthors) o;
        return id == that.id;
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
    @JoinColumn(name = "Author_ID", referencedColumnName = "ID", nullable = false)
    public Author getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(Author authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }
}
