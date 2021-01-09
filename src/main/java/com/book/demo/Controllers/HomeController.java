package com.book.demo.Controllers;

import com.book.demo.DTO.BookDTO;
import com.book.demo.Managers.BookManager;
import com.book.demo.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class HomeController {
    @Autowired
    BookRepository bookRepository;

    BookManager bookManager = new BookManager();

    @RequestMapping("/home")
    public String homePage(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("isLoggedIn") != null) {
            model.addAttribute("isLoggedIn", true);
        }

        ArrayList<BookDTO> myBooks = bookManager.getBooks(bookRepository);
        model.addAttribute("books", myBooks);
        return "home/home";
    }
}
