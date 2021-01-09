package com.book.demo.Managers;

import com.book.demo.DTO.AuthorDTO;
import com.book.demo.DTO.BookDTO;
import com.book.demo.Entities.Author;
import com.book.demo.Entities.Book;
import com.book.demo.Entities.BookAuthors;
import com.book.demo.Repositories.AuthorRepository;

import java.util.ArrayList;

public class AuthorManager {
    public ArrayList<AuthorDTO> getBookAuthorsNames(Book book)
    {
        ArrayList<AuthorDTO> currentAuthors = new ArrayList<>();

        for (BookAuthors bookAuthors : book.getBookAuthorsByIsbn()) {
            AuthorDTO tempAuthor = new AuthorDTO();
            tempAuthor.firstname = bookAuthors.getAuthorByAuthorId().getFirstName();
            tempAuthor.lastname = bookAuthors.getAuthorByAuthorId().getLastName();
            currentAuthors.add(tempAuthor);
        }
        return currentAuthors;
    }
}
