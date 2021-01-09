package com.book.demo.Controllers;

import com.book.demo.DTO.UserDTO;
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
    public String submitLogin(HttpServletRequest request,Model model, @ModelAttribute("userLogin") UserDTO userDTO) {
        User currentUser = UserValidator.userExistsInDataBase(userRepository, userDTO);

        if(currentUser != null) {
            userDTO.fromUserToUserDTO(currentUser);

            request.getSession().setAttribute("isLoggedIn", true);
            request.getSession().setAttribute("user", userDTO);

            model.addAttribute("user", userDTO);
            model.addAttribute("isLoggedIn", true);

            return "myaccount/myaccount";
        } else {
            String error = "Invalid username or password";
            model.addAttribute("error", error);
            return "myaccount/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }
}
