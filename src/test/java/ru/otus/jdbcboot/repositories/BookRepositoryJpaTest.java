package ru.otus.jdbcboot.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import ru.otus.jdbcboot.domain.Book;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

//@DisplayName("Dao для работы с книгой должно")
//@JdbcTest
//@Import(BookRepositoryJpa.class)
//class BookRepositoryJpaTest {
//
//    private static final int EXPECTED_BOOKS_COUNT = 2;
//
//    @Autowired
//    private BookRepositoryJpa dao;
//
//    @DisplayName("возвращать ожидаемое количество книг в БД")
//    @Test
//    void countBookTest() {
//        long actualBooksCount = dao.countBook();
//        assertThat(actualBooksCount).isEqualTo(EXPECTED_BOOKS_COUNT);
//    }
//
//    @DisplayName("добавлять кнгу в БД")
//    @Test
//    void insertBookTest() {
//        var expectedBook = new Book(3, "Anna Karenina", "Leo Tolstoy", "Drama");
//        long id = dao.insertBook(expectedBook);
//        var actualBook = dao.getByBookId(id);
//        assertThat(actualBook).usingRecursiveComparison().isEqualTo(expectedBook);
//    }
//
//    @DisplayName("получать книгу по ID из БД")
//    @Test
//    void getByBookIdTest() {
//        var expectedBook = new Book(1, "War and peace", "Leo Tolstoy", "Drama");
//        var actualBook = dao.getByBookId(1);
//        assertThat(actualBook)
//                .usingRecursiveComparison()
//                .isEqualTo(expectedBook);
//    }
//
//    @DisplayName("получать все книги")
//    @Test
//    void getAllBooksTest() {
//        var expectedBook1 = new Book(1, "War and peace", "Leo Tolstoy", "Drama");
//        var expectedBook2 = new Book(2, "Eugene Onegin", "Alex Pushkin", "Drama");
//        List<Book> expectedBookList = new ArrayList<>();
//        expectedBookList.add(expectedBook1);
//        expectedBookList.add(expectedBook2);
//        var actualBookList = dao.getAllBooks();
//        assertThat(actualBookList)
//                .usingRecursiveFieldByFieldElementComparator()
//                .containsExactlyInAnyOrder(expectedBook1, expectedBook2);
//    }
//
//    @DisplayName("удалять книгу по ID из БД")
//    @Test
//    void deleteBookByIdTest() {
//        assertThatCode(() -> dao.getByBookId(1)).doesNotThrowAnyException();
//        dao.deleteBookById(1);
//        assertThatCode(() -> dao.getByBookId(1)).isInstanceOf(EmptyResultDataAccessException.class);
//    }
//}