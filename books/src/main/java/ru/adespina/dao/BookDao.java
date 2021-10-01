package ru.adespina.dao;

import ru.adespina.models.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    List<Book> findAll() throws SQLException;
    Book save(Book book);
    Book getById(Integer bookId);
    Book update(Book book);
    void delete(Book book);
    void deleteAll();
}
