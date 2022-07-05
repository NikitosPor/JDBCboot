package ru.otus.jdbcboot.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.jdbcboot.dao.BookDaoJdbc;
import ru.otus.jdbcboot.domain.Book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@DisplayName("Тест сервиса BookOperationsService")
@SpringBootTest
class BookOperationsServiceTest {

    @MockBean
    private IOServiceStreams ioService;

    @MockBean
    private BookDaoJdbc bookDaoJdbc;

    @Autowired
    private BookOperationsService bookOperationsService;

    @Test
    void createBookTest() {
        long id = 0;

        given(ioService.readString()).willReturn("Anna Karenina;Leo Tolstoy;Drama");

        assertThat(bookOperationsService.createBook())
                .isEqualTo(id);
    }

    @Test
    void deleteBookByIdTest() {
        Book expectedBook = new Book(0, "Anna Karenina", "Leo Tolstoy", "Drama");
        bookDaoJdbc.insertBook(expectedBook);
        assertThatCode(() -> bookOperationsService.getBookById(0)).doesNotThrowAnyException();
        bookOperationsService.deleteBookById(0);
        assertThatCode(() -> bookOperationsService.getBookById(0)).isNull();
    }

    @Test
    void getBookByIdTest() {
        Book expectedBook = new Book(10, "Anna Karenina", "Leo Tolstoy", "Drama");
        when(bookDaoJdbc.getByBookId(10)).thenReturn(expectedBook); //  дописал А

        assertThat(bookOperationsService.getBookById(10))
                .isEqualTo(expectedBook);
    }

    @Test
    void printNumberOfAllBooksTest() {
    }

    @Test
    void printAllBooksTest() {
    }
}