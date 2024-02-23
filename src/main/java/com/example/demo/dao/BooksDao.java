package com.example.demo.dao;

import com.example.demo.model.BookStorage;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.*;

@Repository("Books")
public class BooksDao {
    private final File file;
    List<String> books = new ArrayList<>();
    public BooksDao() {
        this.file = BookStorage.getFile();
    }

    public List<String> showBookNames() {
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            String bookEntry;
            while ((bookEntry = br.readLine()) != null) {
                String[] book = bookEntry.split(",");
                books.add(book[0]);
            }
        }
        catch (IOException e) {
            System.out.println("" +e);
        }
        return books;
    }

    public List<String> showAllBooksDetails() {
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            String bookEntry;
            while ((bookEntry = br.readLine()) != null) {
                String[] book = bookEntry.split(",");
                String bookDetails = String.format("{'Book Name':'%s', 'Author':'%s', 'Publication':'%s', 'Number of Pages':'%s'}",
                        book[0], book[1], book[2], book[3]);
                books.add(bookDetails);
            }
        }
        catch (IOException e) {
            System.out.println("" + e);
        }
        return books;

    }
}
