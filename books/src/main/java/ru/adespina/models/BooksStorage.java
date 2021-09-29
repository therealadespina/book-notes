package ru.adespina.models;

import java.util.*;

public class BooksStorage<T> {
    private static final Set<Book> books = new HashSet<>();

    public static Set<Book> getBooks() {
        return books;
    }

    static {
        books.add(new Book(String.valueOf(new Random().nextInt(5000000)),"Star Wars: Lost Tribe of the Sith: The Collected Stories", "Джон Джексон Миллер", new Random().nextInt(400)));
        books.add(new Book(String.valueOf(new Random().nextInt(5000000)),"Затерянное племя ситхов: На краю", "Джон Джексон Миллер", new Random().nextInt(400)));
        books.add(new Book(String.valueOf(new Random().nextInt(5000000)),"Звёздные войны. Старая Республика: Реван", "Дрю Карпишин", new Random().nextInt(400)));
        books.add(new Book(String.valueOf(new Random().nextInt(5000000)),"Звёздные войны. Старая Республика: Обманутые", "Пол С. Кемп", new Random().nextInt(400)));
        books.add(new Book(String.valueOf(new Random().nextInt(5000000)),"Красная жатва", "Джо Шрайбер", new Random().nextInt(400)));
        books.add(new Book(String.valueOf(new Random().nextInt(5000000)),"Звёздные войны. Старая Республика: Роковой союз", "Шон Уильямс", new Random().nextInt(400)));
        books.add(new Book(String.valueOf(new Random().nextInt(5000000)),"Звёздные войны. Старая Республика: Истребление", "Дрю Карпишин", new Random().nextInt(400)));
        books.add(new Book(String.valueOf(new Random().nextInt(5000000)),"Затерянное племя ситхов: Пантеон", "Джон Джексон Миллер", new Random().nextInt(400)));
        books.add(new Book(String.valueOf(new Random().nextInt(5000000)),"Странствующий рыцарь", "Дрю Карпишин", new Random().nextInt(400)));
        books.add(new Book(String.valueOf(new Random().nextInt(5000000)),"Наследие джедаев", "Джуд Уотсон", new Random().nextInt(400)));
        books.add(new Book(String.valueOf(new Random().nextInt(5000000)),"Звёздные войны: Дарт Плэгас", "Джеймс Лучено", new Random().nextInt(400)));
        books.add(new Book(String.valueOf(new Random().nextInt(5000000)),"Ученик джедая: Становление Силы", "Дейв Волвертон", new Random().nextInt(400)));
        books.add(new Book(String.valueOf(new Random().nextInt(5000000)),"Ученик джедая: Властитель тёмной силы", "Джуд Уотсон", new Random().nextInt(400)));
        books.add(new Book(String.valueOf(new Random().nextInt(5000000)),"Жизнь и легенда Оби-Вана Кеноби", "Райдер Виндхам", new Random().nextInt(400)));
        books.add(new Book(String.valueOf(new Random().nextInt(5000000)),"Ученик джедая: Единственная свидетельница", "Джуд Уотсон", new Random().nextInt(400)));
        books.add(new Book(String.valueOf(new Random().nextInt(5000000)),"Тайны джедаев", "Джуд Уотсон", new Random().nextInt(400)));
        books.add(new Book(String.valueOf(new Random().nextInt(5000000)),"Восход и падение Дарта Вейдера", "Райдер Виндхам", new Random().nextInt(400)));
        books.add(new Book(String.valueOf(new Random().nextInt(5000000)),"Дарт Мол: Диверсант", "Джеймс Лучено", new Random().nextInt(400)));
    }
}
