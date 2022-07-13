package ru.otus.jdbcboot.service;

import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тест сервиса BookOperationsService")
@SpringBootTest
class BookOperationsServiceTest {
//
//    @MockBean
//    private IOServiceStreams ioService;
//
//    @MockBean
//    private BookRepositoryJpa bookDaoJdbc;
//
//    @Autowired
//    private BookOperationsService bookOperationsService;
//
//    @Test
//    void createBookTest() {
//        long id = 0;
//
//        given(ioService.readString()).willReturn("Anna Karenina;Leo Tolstoy;Drama");
//
//        assertThat(bookOperationsService.createBook())
//                .isEqualTo(id);
//    }
//
//    @Test
//    void deleteBookByIdTest() {
//        Book expectedBook = new Book(0, "Anna Karenina", "Leo Tolstoy", "Drama");
//        bookDaoJdbc.insertBook(expectedBook);
//        assertThatCode(() -> bookOperationsService.getBookById(0)).doesNotThrowAnyException();
//        bookOperationsService.deleteBookById(0);
//        assertThatCode(() -> bookOperationsService.getBookById(0)).isNull();
//    }
//
//    @Test
//    void getBookByIdTest() {
//        Book expectedBook = new Book(10, "Anna Karenina", "Leo Tolstoy", "Drama");
//        when(bookDaoJdbc.getByBookId(10)).thenReturn(Optional.of(expectedBook)); //  дописал А
//
//        assertThat(bookOperationsService.getBookById(10))
//                .isEqualTo(expectedBook);
//    }
//
//    @Test
//    void printNumberOfAllBooksTest() {
//    }
//
//    @Test
//    void printAllBooksTest() {
//    }
}