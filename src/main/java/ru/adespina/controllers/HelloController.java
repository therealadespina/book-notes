package ru.adespina.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.adespina.models.BooksStorage;

import java.util.stream.Collectors;

import static java.lang.String.format;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/books")
    public String books() {
        return BooksStorage
                .getBooks()
                .stream()
                .map(book -> format("%s - %s - %s", book.getName(), book.getAuthor(), book.getPages()))
                .collect(Collectors.joining("</br>"));
    }

}