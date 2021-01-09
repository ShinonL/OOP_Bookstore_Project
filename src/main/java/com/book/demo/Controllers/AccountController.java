package com.book.demo.Controllers;

import com.book.demo.DTO.LoggedUser;
import com.book.demo.Entities.City;
import com.book.demo.Entities.User;
import com.book.demo.Repositories.UserRepository;
import com.book.demo.Validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
public class AccountController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/submitUpdate")
    public String submitUpdate(HttpServletRequest request,Model model, @ModelAttribute("userUpdate") LoggedUser updateUser) {

        LoggedUser currentUser = new LoggedUser();
        currentUser = (LoggedUser)request.getSession().getAttribute("user");

        if(updateUser.getUsername() != null)
        {
            currentUser.setUsername(updateUser.getUsername());
            currentUser.getUser().setUsername(updateUser.getUsername());
        }
        if(updateUser.getPassword() != null)
        {
            currentUser.setPassword(updateUser.getPassword());
            currentUser.getUser().setPassword(updateUser.getPassword());
        }

        userRepository.save(currentUser.getUser());

        model.addAttribute("user",currentUser);
        model.addAttribute("isLoggedIn", true);

        return "myaccount/myaccount";

    }

    @RequestMapping("/myaccount")
    public String accountPage(HttpServletRequest request, Model model) {

        LoggedUser loggedUser = new LoggedUser();
        loggedUser.setUser((User)request.getSession().getAttribute("user"));
        loggedUser.setCity(loggedUser.getUser().getCityByCityId().getName());
        loggedUser.setCountry(loggedUser.getUser().getCityByCityId().getCountryByCountryId().getName());

        model.addAttribute("user",loggedUser);

        return "myaccount/myaccount";
    }
}
