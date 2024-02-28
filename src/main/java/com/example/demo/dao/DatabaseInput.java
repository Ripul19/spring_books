package com.example.demo.dao;

import com.example.demo.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PhpMyAdmin")
public class DatabaseInput {

    private final BooksDao booksDao;

    public DatabaseInput(BooksDao booksDao) {
        this.booksDao = booksDao;
    }

    public List<String> bookNames() {
        return booksDao.bookNames();
    }

    public Book bookDetails(String bookName) {
        return booksDao.bookDetails(bookName);
    }
}
