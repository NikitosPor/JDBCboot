package ru.otus.jdbcboot.repositories;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.jdbcboot.domain.Book;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;


@DisplayName("Dao для работы с книгой должно")
@DataJpaTest
@Import(BookRepositoryJpa.class)
class BookRepositoryJpaTest {

    private static final long EXPECTED_BOOK_ID = 1L;
    private static final int EXPECTED_BOOKS_COUNT = 2;

    private static final List<String> EXPECTED_BOOKS_TITLES = List.of("War and peace", "Eugene Onegin");
    private static final List<String> EXPECTED_BOOK_AUTHORS = List.of("Leo Tolstoy", "Alex Pushkin");
    private static final List<String> EXPECTED_BOOKS_GENRES = List.of("Drama", "Tale");
    // private static final List<String> EXPECTED_BOOKS_COMMENTS = List.of("One of the most epic drama in the world", "Leo Tolstoy wrote it when he was old boy", "Famous literature composition", "The greatest literature monument in tje world");

    @Autowired
    private BookRepositoryJpa repo;

    @Autowired
    private TestEntityManager em;

    //
    @DisplayName("возвращать ожидаемое количество книг в БД")
    @Test
    void countBookTest() {
        long actualBooksCount = repo.countBooks();
        assertThat(actualBooksCount).isEqualTo(EXPECTED_BOOKS_COUNT);
    }

    @DisplayName("добавлять кнгу в БД")
    @Test
    void insertBookTest() {
        var expectedBook = new Book("Anna Karenina", "Leo Tolstoy", "Drama");
        Book book = repo.insertBook(expectedBook);
        var actualBook = repo.findBookById(book.getId());
        assertThat(actualBook).usingRecursiveComparison().isEqualTo(expectedBook);
    }

    @DisplayName("получать книгу по ID из БД")
    @Test
    void getByBookIdTest() {
        val optionalActualBook = repo.findBookById(EXPECTED_BOOK_ID);
        val expectedBook = em.find(Book.class, EXPECTED_BOOK_ID);
        assertThat(optionalActualBook)
                .usingRecursiveComparison().isEqualTo(expectedBook);
    }

    @DisplayName("получать все книги")
    @Test
    void getAllBooksTest() {
        var actualBookList = repo.getAllBooks();
        assertThat(actualBookList).isNotNull().hasSize(EXPECTED_BOOKS_COUNT)
                .allMatch(b -> EXPECTED_BOOKS_TITLES.stream().anyMatch(title -> b.getTitle().contains(title)))
                .allMatch(b -> EXPECTED_BOOK_AUTHORS.stream().anyMatch(author -> b.getAuthor().contains(author)))
                .allMatch(b -> EXPECTED_BOOKS_GENRES.stream().anyMatch(genre -> b.getGenre().contains(genre)))
                .allMatch(b -> b.getComments() != null);
        ;
    }

    @DisplayName("удалять книгу по ID из БД")
    @Test
    void deleteBookByIdTest() {
        assertThatCode(() -> repo.findBookById(1)).doesNotThrowAnyException();
        repo.deleteBookById(1);
        assertThatCode(() -> repo.findBookById(1)).isInstanceOf(Exception.class);
    }
}