package com.book.demo.Controllers;

import com.book.demo.DTO.AuthorDTO;
import com.book.demo.DTO.BookDTO;
import com.book.demo.DTO.GenreDTO;
import com.book.demo.Entities.Book;
import com.book.demo.Managers.AuthorManager;
import com.book.demo.Managers.BookManager;
import com.book.demo.Repositories.AuthorRepository;
import com.book.demo.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class ProductController {
    @Autowired
    BookRepository bookRepository;

    BookManager bookManager = new BookManager();
    AuthorManager authorManager = new AuthorManager();

    @GetMapping("/{isbn}")
    public String productPage(Model model, HttpServletRequest request, @PathVariable("isbn") String isbn_product) {

        if (request.getSession().getAttribute("isLoggedIn") != null) {
            model.addAttribute("isLoggedIn", true);
        }

        Optional<Book> myBook = bookRepository.findById(isbn_product);
        BookDTO dtoBook = bookManager.transformToBookDTO(myBook.get());

        ArrayList<AuthorDTO> dtoAuthors =authorManager.getBookAuthorsNames(myBook.get());
        ArrayList<String> dtoGenres = bookManager.getBookGenreString(myBook.get());

        model.addAttribute("book", dtoBook);
        model.addAttribute("authors", dtoAuthors);
        model.addAttribute("genres", dtoGenres);

        return "product/product";
    }
}
