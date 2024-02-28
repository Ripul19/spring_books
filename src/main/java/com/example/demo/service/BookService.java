package com.example.demo.service;

import com.example.demo.dao.DatabaseInput;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    public final DatabaseInput databaseInput;

    @Autowired
    public BookService(@Qualifier("PhpMyAdmin")DatabaseInput databaseInput) {
        this.databaseInput = databaseInput;
    }

    public ResponseEntity<List<String>> showBookNames(){
        List<String> books = databaseInput.bookNames();
        return ResponseEntity.ok(books);
    }

    public Book showBookDetails(String bookName){
        Book book = databaseInput.bookDetails(bookName);
        return ResponseEntity.ok(book).getBody();
    }

}
