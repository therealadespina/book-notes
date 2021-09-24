package ru.adespina.models;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BooksStorage {
    private static final Set<Book> books = new HashSet<>();

    static {
        books.add(new Book(String.valueOf(new Random().nextInt(5000)),"java", "ad", 3));
        books.add(new Book(String.valueOf(new Random().nextInt(5000)),"js", "ps", 3));
    }

    public static Set<Book> getBooks() {
        return books;
    }
}
