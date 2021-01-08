package com.book.demo.Managers;


import com.book.demo.DTO.BookDTO;
import com.book.demo.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collection;

public class BookManager {
    public ArrayList<BookDTO> getBooks(BookRepository bookRepository) {
        ArrayList<BookDTO> list = new ArrayList<BookDTO>();
        var books = bookRepository.findAll();
        for (var book: books) {
            var newBook = new BookDTO();
            newBook.isbn = book.getIsbn();
            newBook.coverImg = book.getCoverImage();
            newBook.title = book.getTitle();
            newBook.price = book.getPrice();
            list.add(newBook);
        }
        return list;
    }
}
