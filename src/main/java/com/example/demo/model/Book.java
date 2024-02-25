package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    private final String bookName;
    private final String author;
    private final String date;
    private final String pages;

    public Book(@JsonProperty("bookName") String bookName, @JsonProperty("author") String author, @JsonProperty("date") String date, @JsonProperty("pages") String pages) {
        this.bookName = bookName;
        this.author = author;
        this.date = date;
        this.pages = pages;
    }

    public String getBookName(){
        return bookName;
    }

    public String getAuthor(){
        return author;
    }

    public String getDate(){
        return date;
    }
    public String getPages(){
        return pages;
    }
}
