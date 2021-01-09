package com.book.demo.Validators;

import com.book.demo.DTO.UserDTO;
import com.book.demo.Entities.User;
import com.book.demo.Repositories.UserRepository;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    public static User userExistsInDataBase(UserRepository userRepository, UserDTO userDTO) {
        Collection<User> users = userRepository.findAll();
        for (User user : users) {
            if(user.getUsername().equals(userDTO.getUsername()) &&
                    user.getPassword().equals(userDTO.getPassword()))
            {
                return user;
            }
        }
        return null;
    }

    public static boolean isValidUser(UserRepository userRepository, UserDTO user) {
        if(!isValidUsername(userRepository, user.getUsername()))
            return false;
        if(!isValidEmail(userRepository, user.getEmail()))
            return false;
        if(!isValidName(user.getFirstName()))
            return false;
        if(!isValidName(user.getLastName()))
            return false;
        if(!isValidPhone(user.getPhone()))
            return false;
        if(!isValidName(user.getCity()))
            return false;
        if(!isValidName(user.getCountry()))
            return false;
        return true;
    }

    public static boolean isValidUsername(UserRepository userRepository, String username) {
        if(username.isEmpty()) return true;
        if(username.matches("\\b[a-zA-Z][a-zA-Z0-9\\-._]{3,}\\b")) {
            User user = userRepository.findUserByUsername(username);
            return user == null;
        }
        return false;
    }

    public static boolean isValidEmail(UserRepository userRepository, String email) {
        if(email.isEmpty()) return true;
        if(validateEmail(email)) {
            User user = userRepository.findUserByEmail(email);
            return user == null;
        }
        return false;
    }

    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidName(String name) {
        if(name.isEmpty()) return true;
        return name.matches("[A-Z][a-z]{2,40}");
    }

    public static boolean isValidPhone(String phone) {
        if(phone.isEmpty()) return true;
        return phone.matches("[0-9]{10}");
    }

}
