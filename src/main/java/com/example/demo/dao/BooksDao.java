package com.example.demo.dao;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksDao extends JpaRepository<Book, Long> {

    @Query("Select bookName from Book")
    List<String> bookNames();

    @Query("Select b from Book b where b.bookName = :bookName")
    Book bookDetails(String bookName);
}
