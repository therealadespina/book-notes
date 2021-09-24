package ru.adespina.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.adespina.models.BooksStorage;

@Controller
public class BooksController {
    @GetMapping("/")
    public String bookList(Model model) {
        model.addAttribute("books", BooksStorage.getBooks());
        return "books-list";
    }

    @GetMapping("/create-form")
    public String createForm() {
        return "create-form";
    }
}
