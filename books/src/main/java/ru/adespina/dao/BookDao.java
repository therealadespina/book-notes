package ru.adespina.dao;

import ru.adespina.models.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll();
    Book save(Book book);
    Book getById(Integer bookId);
    Book update(Book book);
    void delete(Book book);
}
