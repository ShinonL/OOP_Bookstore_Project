package com.book.demo.Controllers;

import com.book.demo.DTO.BookDTO;
import com.book.demo.DTO.ShoppingCartStatus;
import com.book.demo.DTO.UserDTO;
import com.book.demo.Managers.BookManager;
import com.book.demo.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;

@Controller
public class ShoppingCartController {
    @Autowired
    BookRepository bookRepository;
    BookManager bookManager = new BookManager();

    @RequestMapping("/shoppingCart")
    public String cart(HttpServletRequest request, Model model) {
        if(request.getSession().getAttribute("isLoggedIn") == null) {
            return "redirect:/login";
        }

        UserDTO user = (UserDTO)request.getSession().getAttribute("user");
        double subtotal = 0;
        for (BookDTO book: user.getShoppingBooks()) {
            subtotal += Math.round(book.price*book.ammount * 100.0) / 100.0;
        }
        
        String cartStatus="";
        if(user.getShoppingBooks().size()==0)
        {
            if(user.getCartStatus()==ShoppingCartStatus.CHECK_OUT)
            {
                cartStatus = "Check out successfully!";
            }
            else if(user.getCartStatus()==ShoppingCartStatus.CLEARED)
            {
                cartStatus = "Cart cleared successfully!";
            }
            user.setCartStatus(ShoppingCartStatus.NORMAL);
        }
        else
        {
            cartStatus = "";
        }

        model.addAttribute("books", user.getShoppingBooks());
        model.addAttribute("subtotal", subtotal);
        model.addAttribute("total", Math.round((subtotal+15) * 100.0) / 100.0);
        model.addAttribute("cart",cartStatus);

        return "cart/cart";
    }

    @RequestMapping("/{isbn}/addToCart")
    public String addToCart(HttpServletRequest request, @PathVariable("isbn") String isbn) {
        if (request.getSession().getAttribute("isLoggedIn") == null) {
            return "redirect:/login";
        }

        BookDTO book = bookManager.transformToBookDTO(bookRepository.findBookByIsbn(isbn));
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        if(user.getShoppingBooks().isEmpty()) {
            book.ammount = 1;
            user.getShoppingBooks().add(book);
        } else {
            int ok = 0;
            for (BookDTO addedBook: user.getShoppingBooks()) {
                if(addedBook.isbn.equals(isbn)) {
                    addedBook.ammount++;
                    ok = 1;
                    break;
                }
            }
            if(ok == 0) {
                book.ammount = 1;
                user.getShoppingBooks().add(book);
            }
        }
        request.getSession().setAttribute("user", user);

        return "redirect:/shoppingCart";
    }

    @RequestMapping("/{isbn}/removeFromCart")
    public String removeFromCart(HttpServletRequest request, @PathVariable("isbn") String isbn) {

        if (request.getSession().getAttribute("isLoggedIn") == null) {
            return "redirect:/login";
        }

        BookDTO book = bookManager.transformToBookDTO(bookRepository.findBookByIsbn(isbn));
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        user.removeBookFromShoppingList(book);

        request.getSession().setAttribute("user", user);

        return "redirect:/shoppingCart";
    }
    @RequestMapping("/{isbn}/minusBook")
    public String minusBook(HttpServletRequest request, @PathVariable("isbn") String isbn) {

        if (request.getSession().getAttribute("isLoggedIn") == null) {
            return "redirect:/login";
        }

        BookDTO book = bookManager.transformToBookDTO(bookRepository.findBookByIsbn(isbn));
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        for (BookDTO shoppingBook : user.getShoppingBooks()) {
            if(shoppingBook.isbn.equals(isbn))
            {
                if(shoppingBook.ammount > 1)
                {
                    shoppingBook.ammount--;
                }
                break;
            }
        }

        request.getSession().setAttribute("user", user);

        return "redirect:/shoppingCart";
    }

    @RequestMapping("/{isbn}/plusBook")
    public String plusBook(HttpServletRequest request, @PathVariable("isbn") String isbn) {

        if (request.getSession().getAttribute("isLoggedIn") == null) {
            return "redirect:/login";
        }

        BookDTO book = bookManager.transformToBookDTO(bookRepository.findBookByIsbn(isbn));
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        for (BookDTO shoppingBook : user.getShoppingBooks()) {
            if(shoppingBook.isbn.equals(isbn))
            {
                shoppingBook.ammount++;
                break;
            }
        }

        request.getSession().setAttribute("user", user);

        return "redirect:/shoppingCart";
    }
    @RequestMapping("/checkout")
    public String checkout(HttpServletRequest request) {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");

        if(user.getShoppingBooks().size()>0){
            user.setCartStatus(ShoppingCartStatus.CHECK_OUT);
        }

        user.getShoppingBooks().clear();
        request.getSession().setAttribute("user", user);
        return "redirect:/shoppingCart";
    }

    @RequestMapping("/clearList")
    public String clearList(HttpServletRequest request) {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");

        if(user.getShoppingBooks().size()>0){
            user.setCartStatus(ShoppingCartStatus.CLEARED);
        }

        user.getShoppingBooks().clear();
        request.getSession().setAttribute("user", user);
        return "redirect:/shoppingCart";
    }
}
