package ru.otus.jdbcboot.repositories;

import ru.otus.jdbcboot.domain.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepository {

    int countBook();

    long insertBook(Book book);

    Optional<Book> getByBookId(long id);

    List<Book> getAllBooks();

    void updateTitleById(long id, String title);

    void deleteBookById(long id);

}
