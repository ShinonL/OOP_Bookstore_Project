package com.book.demo.Validators;

import com.book.demo.DTO.LoggedUser;
import com.book.demo.Entities.User;
import com.book.demo.Repositories.UserRepository;

import java.util.ArrayList;
import java.util.Collection;

public class UserValidator {

    public static User userExistsInDataBase(UserRepository userRepository, LoggedUser loggedUser)
    {
        Collection<User> users = userRepository.findAll();

        for (User user : users) {
            if(user.getUsername().equals(loggedUser.getUsername()) &&
                    user.getPassword().equals(loggedUser.getPassword()))
            {
                return user;
            }
        }
        return null;
    }

}
