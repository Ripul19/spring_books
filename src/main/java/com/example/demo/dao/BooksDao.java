package com.example.demo.dao;

import com.example.demo.model.Book;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.*;

@Repository("Books")
public class BooksDao {

    private static final String FILE_PATH = "data/books.txt";
    private static final @NotNull List<Book> books = readFile();

    private static @NotNull List<Book> readFile(){
        List<Book> books = new ArrayList<>();
        try{
            File file = new ClassPathResource(FILE_PATH).getFile();
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String bookEntry;
            while ((bookEntry = br.readLine()) != null) {
                String[] parts = bookEntry.split(",");
//                int pages = Integer.parseInt(parts[3]);
                Book book = new Book(parts[0], parts[1], parts[2], parts[3]);
                books.add(book);
            }

        }
        catch(IOException e){
            System.out.println("" + e);
        }
        return books;
    }

    public @NotNull List<String> bookNames() {
        List<String> bookNames = new ArrayList<>();

        for(Book book : books){
            bookNames.add(book.bookName());
        }
        return bookNames;
    }

    public Book bookDetails(String bookName) {
        return books.stream()
                .filter(item -> item.bookName().equals(bookName))
                .findFirst()
                .orElse(null);
    }
}
