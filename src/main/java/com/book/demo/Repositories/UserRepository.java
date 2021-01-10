package com.book.demo.Repositories;

import com.book.demo.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findUserByUsername(String username);
    User findUserByEmail(String email);
}
