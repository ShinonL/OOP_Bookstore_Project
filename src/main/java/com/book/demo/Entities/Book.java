package com.book.demo.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Book {
    private String isbn;
    private String title;
    private Date publishDate;
    private int quantity;
    private double price;
    private String coverImage;
    private double rating;
    private int reviewsNumber;
    private Collection<BookAuthors> bookAuthorsByIsbn;
    private Collection<BookGenre> bookGenresByIsbn;

    @Id
    @Column(name = "ISBN", nullable = false, length = 30)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "Title", nullable = false, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Publish_Date", nullable = false)
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Basic
    @Column(name = "Quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "Price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Cover_Image", nullable = true, length = 255)
    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    @Basic
    @Column(name = "Rating", nullable = false, precision = 0)
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "Reviews_Number", nullable = false)
    public int getReviewsNumber() {
        return reviewsNumber;
    }

    public void setReviewsNumber(int reviewsNumber) {
        this.reviewsNumber = reviewsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return quantity == book.quantity &&
                Double.compare(book.price, price) == 0 &&
                Double.compare(book.rating, rating) == 0 &&
                reviewsNumber == book.reviewsNumber &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(title, book.title) &&
                Objects.equals(publishDate, book.publishDate) &&
                Objects.equals(coverImage, book.coverImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, publishDate, quantity, price, coverImage, rating, reviewsNumber);
    }

    @OneToMany(mappedBy = "bookByIsbn")
    public Collection<BookAuthors> getBookAuthorsByIsbn() {
        return bookAuthorsByIsbn;
    }

    public void setBookAuthorsByIsbn(Collection<BookAuthors> bookAuthorsByIsbn) {
        this.bookAuthorsByIsbn = bookAuthorsByIsbn;
    }

    @OneToMany(mappedBy = "bookByIsbn")
    public Collection<BookGenre> getBookGenresByIsbn() {
        return bookGenresByIsbn;
    }

    public void setBookGenresByIsbn(Collection<BookGenre> bookGenresByIsbn) {
        this.bookGenresByIsbn = bookGenresByIsbn;
    }



}
