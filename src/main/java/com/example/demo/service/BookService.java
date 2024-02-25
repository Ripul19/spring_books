package com.example.demo.service;

import com.example.demo.dao.BooksDao;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    public final BooksDao booksDao;

    @Autowired
    public BookService(@Qualifier("Books") BooksDao booksDao) {
        this.booksDao = booksDao;
    }

    public List<String> showBookNames(){
        return booksDao.bookNames();
    }

    public Book showBookDetails(String bookName) {
        return booksDao.bookDetails(bookName);
    }
}
