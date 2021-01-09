package com.book.demo.DTO;

import com.book.demo.Entities.User;

import java.util.ArrayList;

public class LoggedUser {
    private User user;
    private ArrayList<BookDTO> shoppingBooks;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
