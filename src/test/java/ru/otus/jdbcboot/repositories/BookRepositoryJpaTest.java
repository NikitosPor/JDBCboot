package ru.otus.jdbcboot.repositories;

import lombok.val;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.jdbc.spi.SqlStatementLogger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.jdbcboot.domain.Book;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;


//@DisplayName("Dao для работы с книгой должно")
//@DataJpaTest
//@Import(BookRepositoryJpa.class)
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
//class BookRepositoryJpaTest {
//
//    private static final long EXPECTED_BOOK_ID = 1L;
//    private static final int EXPECTED_BOOKS_COUNT = 2;
//
//    @Autowired
//    private BookRepositoryJpa repo;
//
//    @Autowired
//    private TestEntityManager em;
////
////    @DisplayName("возвращать ожидаемое количество книг в БД")
////    @Test
////    void countBookTest() {
////        long actualBooksCount = dao.countBook();
////        assertThat(actualBooksCount).isEqualTo(EXPECTED_BOOKS_COUNT);
////    }
////
////    @DisplayName("добавлять кнгу в БД")
////    @Test
////    void insertBookTest() {
////        var expectedBook = new Book(3, "Anna Karenina", "Leo Tolstoy", "Drama");
////        long id = dao.insertBook(expectedBook);
////        var actualBook = dao.getByBookId(id);
////        assertThat(actualBook).usingRecursiveComparison().isEqualTo(expectedBook);
////    }
////
//    @DisplayName("получать книгу по ID из БД")
//    @Test
//    void getByBookIdTest() {
//      em.merge(new Book("Ruslan and Ludmila", "Alex Pushkin", "Drama"));
//  //      val actualBook = repo.getBookById(EXPECTED_BOOK_ID);
// //       val expectedStudent = em.find(Book.class, EXPECTED_BOOK_ID);
// //       assertThat(optionalActualStudent)
////                .usingRecursiveComparison().isEqualTo(expectedStudent);
//    }
////
////    @DisplayName("получать все книги")
////    @Test
////    void getAllBooksTest() {
////        var expectedBook1 = new Book(1, "War and peace", "Leo Tolstoy", "Drama");
////        var expectedBook2 = new Book(2, "Eugene Onegin", "Alex Pushkin", "Drama");
////        List<Book> expectedBookList = new ArrayList<>();
////        expectedBookList.add(expectedBook1);
////        expectedBookList.add(expectedBook2);
////        var actualBookList = dao.getAllBooks();
////        assertThat(actualBookList)
////                .usingRecursiveFieldByFieldElementComparator()
////                .containsExactlyInAnyOrder(expectedBook1, expectedBook2);
////    }
////
////    @DisplayName("удалять книгу по ID из БД")
////    @Test
////    void deleteBookByIdTest() {
////        assertThatCode(() -> dao.getByBookId(1)).doesNotThrowAnyException();
////        dao.deleteBookById(1);
////        assertThatCode(() -> dao.getByBookId(1)).isInstanceOf(EmptyResultDataAccessException.class);
////    }
//}