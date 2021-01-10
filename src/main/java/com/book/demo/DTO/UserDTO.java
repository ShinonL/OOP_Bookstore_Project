package com.book.demo.DTO;

import com.book.demo.Entities.User;

import java.util.ArrayList;

public class UserDTO {
    private String username;
    private String password;
    private String city;
    private String country;
    private String email;
    private String lastName;
    private String firstName;
    private String phone;
    private String address;
    private ArrayList<BookDTO> shoppingBooks = new ArrayList<>();
    private ShoppingCartStatus cartStatus;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public void removeBookFromShoppingList(BookDTO book)
    {
        for (BookDTO shoppingBook : shoppingBooks) {
            if(book.isbn.equals(shoppingBook.isbn))
            {
                shoppingBooks.remove(shoppingBook);
                break;
            }
        }
    }

    public void fromUserToUserDTO(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.city = user.getCityByCityId().getName();
        this.country = user.getCityByCityId().getCountryByCountryId().getName();
        this.address = user.getAddress();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }

    public ShoppingCartStatus getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(ShoppingCartStatus cartStatus) {
        this.cartStatus = cartStatus;
    }
}
