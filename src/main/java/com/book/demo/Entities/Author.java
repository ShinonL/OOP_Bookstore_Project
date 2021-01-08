package com.book.demo.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Author {
    private int id;
    private String firstName;
    private String lastName;
    private Collection<BookAuthors> bookAuthorsById;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "First_Name", nullable = false, length = 60)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "Last_Name", nullable = true, length = 60)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @OneToMany(mappedBy = "authorByAuthorId")
    public Collection<BookAuthors> getBookAuthorsById() {
        return bookAuthorsById;
    }

    public void setBookAuthorsById(Collection<BookAuthors> bookAuthorsById) {
        this.bookAuthorsById = bookAuthorsById;
    }
}
