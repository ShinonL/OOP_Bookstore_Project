package com.book.demo.DTO;

import com.book.demo.Entities.User;

import java.util.ArrayList;

public class LoggedUser {
    private String username;
    private String password;
    private User user;
    private String city;
    private String country;
    private ArrayList<BookDTO> shoppingBooks;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<BookDTO> getShoppingBooks() {
        return shoppingBooks;
    }

    public void setShoppingBooks(ArrayList<BookDTO> shoppingBooks) {
        this.shoppingBooks = shoppingBooks;
    }

    public void addBookToShoppingList(BookDTO book)
    {
        for (BookDTO shoppingBook : this.shoppingBooks) {
            if(shoppingBook.isbn.equals(book.isbn))
            {
                shoppingBook.ammount++;
                return;
            }
        }

        book.ammount = 1;
        this.shoppingBooks.add(book);
    }

}
