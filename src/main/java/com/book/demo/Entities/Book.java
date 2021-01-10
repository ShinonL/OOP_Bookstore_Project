package com.book.demo.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

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

        if (quantity != book.quantity) return false;
        if (Double.compare(book.price, price) != 0) return false;
        if (Double.compare(book.rating, rating) != 0) return false;
        if (reviewsNumber != book.reviewsNumber) return false;
        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (publishDate != null ? !publishDate.equals(book.publishDate) : book.publishDate != null) return false;
        if (coverImage != null ? !coverImage.equals(book.coverImage) : book.coverImage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = isbn != null ? isbn.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + quantity;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (coverImage != null ? coverImage.hashCode() : 0);
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + reviewsNumber;
        return result;
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
