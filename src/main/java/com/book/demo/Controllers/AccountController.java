package com.book.demo.Controllers;

import com.book.demo.DTO.UserDTO;
import com.book.demo.Entities.City;
import com.book.demo.Entities.Country;
import com.book.demo.Entities.User;
import com.book.demo.Repositories.CityRepository;
import com.book.demo.Repositories.CountryRepository;
import com.book.demo.Repositories.UserRepository;
import com.book.demo.Validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    CountryRepository countryRepository;

    @PostMapping("/submitUpdate")
    public String submitUpdate(HttpServletRequest request, Model model, @ModelAttribute("userUpdate") UserDTO updateUser) {
        UserDTO currentUser = (UserDTO) request.getSession().getAttribute("user");
        User user = userRepository.findUserByUsername(currentUser.getUsername());
        String error = null;

        if(UserValidator.isValidUser(userRepository, updateUser)) {
            // update username
            if (!updateUser.getUsername().isEmpty()) {
                userRepository.deleteById(user.getUsername());
                user.setUsername(updateUser.getUsername());
            }

            // update password
            if (!updateUser.getPassword().isEmpty()) {
                user.setPassword(updateUser.getPassword());
            }

            // update first name
            if (!updateUser.getFirstName().isEmpty()) {
                user.setFirstName(updateUser.getFirstName());
            }

            // update last name
            if (!updateUser.getLastName().isEmpty()) {
                user.setLastName(updateUser.getLastName());
            }

            // update phone
            if (!updateUser.getPhone().isEmpty()) {
                user.setPhone(updateUser.getPhone());
            }

            // update address
            if (!updateUser.getAddress().isEmpty()) {
                user.setAddress(updateUser.getAddress());
            }

            // update email
            if (!updateUser.getEmail().isEmpty()) {
                user.setEmail(updateUser.getEmail());
            }

            // update Country
            Country country;
            if(!updateUser.getCountry().isEmpty()) {
                country = countryRepository.findCountryByName(updateUser.getCountry());
                if(country == null) {
                    country = new Country();
                    country.setId(countryRepository.findAll().size()+1);
                    country.setName(updateUser.getCountry());
                    countryRepository.save(country);
                }
            } else country = countryRepository.findCountryByName(currentUser.getCountry());

            // update city
            if(!updateUser.getCity().isEmpty()) {
                City city = cityRepository.findCityByName(updateUser.getCity());
                if (city == null) {
                    city = new City();
                    city.setId(cityRepository.findAll().size() + 1);
                    city.setName(updateUser.getCity());
                    city.setCountryByCountryId(country);
                    cityRepository.save(city);
                }
                user.setCityByCityId(city);
            }
        } else error = "Invalid data inserted";

        if(error == null) {
            userRepository.save(user);
            currentUser.fromUserToUserDTO(user);
        }

        model.addAttribute("user", currentUser);
        model.addAttribute("isLoggedIn", true);
        model.addAttribute("error", error);

        return "myaccount/myaccount";

    }

    @RequestMapping("/myaccount")
    public String accountPage(HttpServletRequest request, Model model) {
        if(request.getSession().getAttribute("isLoggedIn") == null) {
            return "redirect:/login";
        } else {
            UserDTO userDTO = (UserDTO)request.getSession().getAttribute("user");
            model.addAttribute("user", userDTO);
            return "myaccount/myaccount";
        }
    }
}
