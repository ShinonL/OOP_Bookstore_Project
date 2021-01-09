package com.book.demo.Controllers;

import com.book.demo.DTO.LoggedUser;
import com.book.demo.Entities.User;
import com.book.demo.Repositories.UserRepository;
import com.book.demo.Validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "myaccount/login";
    }

    @PostMapping("/submitLogin")
    public String submitLogin(HttpServletRequest request,Model model, @ModelAttribute("userLogin") LoggedUser loggedUser) {

        System.out.println(loggedUser.getUsername());
        User currentUser = UserValidator.userExistsInDataBase(userRepository,loggedUser);

        if(currentUser!=null)
        {
            loggedUser.setUser(currentUser);
            loggedUser.setCity(loggedUser.getUser().getCityByCityId().getName());
            loggedUser.setCountry(loggedUser.getUser().getCityByCityId().getCountryByCountryId().getName());

            model.addAttribute("user",loggedUser);

            request.getSession().setAttribute("isLoggedIn",loggedUser);

            model.addAttribute("isLoggedIn", true);

            return "myaccount/myaccount";
        }
        else
        {
            String error = "Invalid username or password";
            model.addAttribute("error", error);
            return "myaccount/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/home/home";
    }

    @GetMapping("/myaccount")
    public String myAccount(HttpServletRequest request,Model model)
    {
        System.out.println("User: "+ request.getSession().getAttribute("isLoggedIn"));
        if(request.getSession().getAttribute("isLoggedIn")==null)
        {
            return "myaccount/login";
        }
        else
        {
            LoggedUser loggedUser = (LoggedUser)request.getSession().getAttribute("isLoggedIn");
            model.addAttribute("user",loggedUser);
            return "myaccount/myaccount";
        }
    }

}
