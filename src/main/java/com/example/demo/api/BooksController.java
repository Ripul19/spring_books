package com.example.demo.api;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/books")
@RestController
public class BooksController {

    public final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<String> getBookNames(){
        return bookService.showBookNames();
    }

    @GetMapping(path = "{bookName}")
    public Book getBookDetails(@PathVariable("bookName") String bookName){
        return bookService.showBookDetails(bookName);
    }
}
