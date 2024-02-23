package com.example.demo.service;

import com.example.demo.dao.BooksDao;
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

    public List<String> showBooks(){
        return booksDao.showBookNames();
    }

    public List<String> showBookDetails(){
        return booksDao.showAllBooksDetails();
    }

}
