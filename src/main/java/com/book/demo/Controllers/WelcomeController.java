package com.book.demo.Controllers;

import com.book.demo.DTO.BookDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
@Controller
public class WelcomeController {
    @RequestMapping("/welcome")
    public String welcomePage(Model model, HttpServletRequest request) {
        return "welcome/welcome";
    }
}
