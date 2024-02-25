package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Book(String bookName, String author, String date, String pages) {
    public Book(@JsonProperty("bookName") String bookName, @JsonProperty("author") String author, @JsonProperty("date") String date, @JsonProperty("pages") String pages) {
        this.bookName = bookName;
        this.author = author;
        this.date = date;
        this.pages = pages;
    }
}
