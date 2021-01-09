package com.book.demo.Repositories;

import com.book.demo.Entities.Author;
import com.book.demo.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
