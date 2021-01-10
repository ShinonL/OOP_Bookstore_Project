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

@Controller
public class RegisterController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    CountryRepository countryRepository;

    @RequestMapping("/register")
    public String register() {
        return "myaccount/register";
    }

    @PostMapping("/submitRegister")
    public String submitRegister(Model model, @ModelAttribute("userRegister") UserDTO inputData) {
        String error = null;

        if(!UserValidator.isValidUsername(userRepository, inputData.getUsername()))
            error = "Username already taken. ";
        if(!UserValidator.isValidEmail(userRepository, inputData.getEmail()))
            error += "Email already taken. ";
        if(!UserValidator.isValidUser(userRepository, inputData))
            error += "Invalid data.";
        if(error != null) {
            model.addAttribute("error", error);
            return "myaccount/register";
        }

        Country country;
        country = countryRepository.findCountryByName(inputData.getCountry());
        if(country == null) {
            country = new Country();
            country.setId(countryRepository.findAll().size()+1);
            country.setName(inputData.getCountry());
            countryRepository.save(country);
        }

        City city = cityRepository.findCityByName(inputData.getCity());
        if (city == null) {
            city = new City();
            city.setId(cityRepository.findAll().size() + 1);
            city.setName(inputData.getCity());
            city.setCountryByCountryId(country);
            cityRepository.save(city);
        }

        User user = new User();
        user.setUsername(inputData.getUsername());
        user.setPassword(inputData.getPassword());
        user.setLastName(inputData.getLastName());
        user.setFirstName(inputData.getFirstName());
        user.setAddress(inputData.getAddress());
        user.setPhone(inputData.getPhone());
        user.setEmail(inputData.getEmail());
        user.setCityByCityId(city);

        userRepository.save(user);

        return "redirect:/login";
    }
}
