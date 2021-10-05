package ru.adespina.springtest;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.adespina.dao.BookDao;
import ru.adespina.models.Book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest(
        properties = {"jdbcUrl=jdbc:h2:mem:db;DB_CLOSE_DELAY=-1"}
)

class BookDaoImplTest {
    @Autowired
    private BookDao bookDao;

    @BeforeEach
    public void beforeEach() {
        bookDao.deleteAll();
    }

    @Test
    void contextCreated() {
    }

    @Test
    void saveSavesDataToDdAndReturnsEntityWithId() {
        Book book = bookDao.save(new Book("book-name", "book-author", 1));
        assertThat(book.getId()).isNotBlank();
        assertThat(bookDao.findAll())
                .extracting("id")
                .containsExactly(book.getId());
    }

    @Test
    void deleteAllDeleteAllData() {
        bookDao.save(new Book("book-name", "book-author", 1));
        assertThat(bookDao.findAll()).isNotEmpty();
        bookDao.deleteAll();
        assertThat(bookDao.findAll()).isEmpty();
    }

    @Test
    void findAllReturnsAllBooks() {
        assertThat(bookDao.findAll()).isEmpty();
        bookDao.save(new Book("book-name", "book-author", 1));
        assertThat(bookDao.findAll()).isNotEmpty();
    }

    @Test
    void getByIdThrowsRuntimeExceptionIfNoBookFound() {
        assertThatThrownBy(() -> bookDao.getById("1")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void getByIdReturnsCorrectBook() {
        Book book1 = bookDao.save(new Book("book-name", "book-author", 1));
        bookDao.save(new Book("book-author1", "book-author1", 2));

        assertThat(bookDao.getById(book1.getId()))
                .isNotNull()
                .extracting("name")
                .isEqualTo(book1.getName());
    }

    @Test
    void  updateUpdateDataInDb() {
        Book book = bookDao.save(new Book("book-name", "book-author", 1));
        book.setName("new-name");

        bookDao.update(book);

        assertThat(bookDao.getById(book.getId()).getName()).isEqualTo("new-name");
    }

    @Test
    void updateThrowsExceptionOnUpdatingNotSavedBook() {
        assertThatThrownBy(() -> bookDao.update(new Book("book-name", "book-author", 1)))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void deleteDeleteCorrectData() {
        Book book1 = bookDao.save(new Book("book-name", "book-author", 1));
        Book book2 = bookDao.save(new Book("book-name1", "book-author1", 2));

        bookDao.delete(book2);
        assertThat(bookDao.getById(book1.getId())).isNotNull();
        assertThatThrownBy(() -> bookDao.getById(book2.getId())).isInstanceOf(RuntimeException.class);
    }
}