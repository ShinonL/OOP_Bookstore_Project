package com.book.demo.Controllers;

import com.book.demo.DTO.BookDTO;
import com.book.demo.Managers.BookManager;
import com.book.demo.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RequestMapping("/category")
@Controller
public class CategoryController {
    @Autowired
    BookRepository bookRepository;

    BookManager bookManager = new BookManager();

    @GetMapping("/{category}")
    public String categoryPage(Model model, HttpServletRequest request, @PathVariable("category") String category) {

        if (request.getSession().getAttribute("isLoggedIn") != null) {
            model.addAttribute("isLoggedIn", true);
        }

        ArrayList<BookDTO> myBooks = bookManager.getBooksByCategory(bookRepository, category);
        model.addAttribute("books", myBooks);
        model.addAttribute("category", category);
        return "category/category";
    }
}
