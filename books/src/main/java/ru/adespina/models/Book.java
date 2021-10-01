package ru.adespina.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Book {

    private String id;
    private String name;
    private String author;
    private int pages;

    public Book(String id, String name, String author, int pages) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
    }

    public Book(String name, String author, int pages) {
        this.name = name;
        this.author = author;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }
}
