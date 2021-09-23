package ru.adespina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.adespina.models.Book;
import ru.adespina.models.BooksStorage;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        BooksStorage.getBooks().add(new Book("java", "adespina", 400));
        BooksStorage.getBooks().add(new Book("js", "adespina", 500));
        SpringApplication.run(Application.class, args);
    }
}