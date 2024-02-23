package com.example.demo.model;

import java.io.File;

public class BookStorage {
    private static final String currentDirectory = System.getProperty("user.dir");
    private static final String filePath = currentDirectory+ "\\books.txt";

    public static File getFile(){
        return new File(filePath);
    }
}

