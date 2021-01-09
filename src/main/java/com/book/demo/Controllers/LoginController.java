package com.book.demo.Controllers;

import com.book.demo.DTO.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "myaccount/login";
    }

    @PostMapping("/submitLogin")
    public String submitLogin(HttpServletRequest request, Model model) {
        LoggedUser loggedUser = new LoggedUser();
        request.getSession().setAttribute("isLoggedIn",loggedUser);
        model.addAttribute("isLoggedIn", true);
        return "/myaccount/myaccount";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/home/home";
    }

}
