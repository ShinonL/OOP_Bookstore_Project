package com.book.demo.Managers;


import com.book.demo.DTO.BookDTO;
import com.book.demo.DTO.GenreDTO;
import com.book.demo.Entities.Book;
import com.book.demo.Entities.BookGenre;
import com.book.demo.Repositories.BookRepository;

import java.util.ArrayList;

public class BookManager {

    public ArrayList<String> getBookGenreString(Book currentBooks)
    {
        ArrayList<String> currentGenres = new ArrayList<>();
        for (BookGenre bookGenre : currentBooks.getBookGenresByIsbn()) {
            currentGenres.add(bookGenre.getGenreByGenreId().getGenre());
        }
        return currentGenres;
    }

    public ArrayList<BookDTO> getBooksByCategory(BookRepository bookRepository, String category) {
        ArrayList<BookDTO> list = new ArrayList<BookDTO>();
        var books = bookRepository.findAll();
        for (var book: books) {

            GenreDTO currentGenre = new GenreDTO();
            currentGenre.name = category;

            if(getBookGenreString(book).contains(category))
            {
                var newBook = new BookDTO();
                newBook.isbn = book.getIsbn();
                newBook.coverImg = book.getCoverImage();
                newBook.title = book.getTitle();
                newBook.price = book.getPrice();
                list.add(newBook);
            }
        }
        return list;
    }

    public ArrayList<BookDTO> getBooks(BookRepository bookRepository) {
        ArrayList<BookDTO> list = new ArrayList<BookDTO>();
        var books = bookRepository.findAll();
        for (var book: books) {
            var newBook = new BookDTO();
            newBook.isbn = book.getIsbn();
            newBook.coverImg = book.getCoverImage();
            newBook.title = book.getTitle();
            newBook.price = book.getPrice();
            newBook.rating = book.getRating();
            newBook.ratingNumber = book.getReviewsNumber();
            list.add(newBook);
        }
        return list;
    }

    public BookDTO transformToBookDTO(Book book)
    {
        BookDTO currentBook = new BookDTO();
        currentBook.isbn = book.getIsbn();
        currentBook.title = book.getTitle();
        currentBook.coverImg = book.getCoverImage();
        currentBook.price = book.getPrice();
        currentBook.rating = book.getRating();
        currentBook.ratingNumber = book.getReviewsNumber();
        currentBook.publishDate = book.getPublishDate();

        return currentBook;
    }
}
