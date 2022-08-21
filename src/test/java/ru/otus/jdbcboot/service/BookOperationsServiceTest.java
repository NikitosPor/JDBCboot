package ru.otus.jdbcboot.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.jdbcboot.repositories.BookRepositoryJpa;
import ru.otus.jdbcboot.domain.Book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.when;

@DisplayName("Тест сервиса BookOperationsService")
@SpringBootTest
class BookOperationsServiceTest {

    private static final Book EXPECTED_BOOK = new Book(5, "Anna Karenina", "Leo Tolstoy", "Drama");

    @MockBean
    private IOServiceStreams ioService;

    @MockBean
    private BookRepositoryJpa bookRepo;

    @Autowired
    private BookOperationsService bookOperationsService;

    @Test
    void createBookTest() {

    }

    @Test
    void deleteBookByIdTest() {
        Book expectedBook = new Book(0, "Anna Karenina", "Leo Tolstoy", "Drama");
        bookRepo.insertBook(expectedBook);
        assertThatCode(() -> bookOperationsService.getBookById(0)).doesNotThrowAnyException();
        bookOperationsService.deleteBookById(0);
        assertThatCode(() -> bookOperationsService.getBookById(0)).isNull();
    }

    @Test
    void getBookByIdTest() {
        Book expectedBook = new Book(10, "Anna Karenina", "Leo Tolstoy", "Drama");
        when(bookRepo.findBookById(10)).thenReturn(expectedBook); //  дописал А

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