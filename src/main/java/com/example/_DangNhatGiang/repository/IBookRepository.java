package com.example._DangNhatGiang.repository;

import com.example._DangNhatGiang.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String name);
}
