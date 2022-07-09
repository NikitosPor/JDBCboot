package ru.otus.jdbcboot.repositories;

import ru.otus.jdbcboot.domain.Book;
import java.util.List;

public interface BookRepository {

    long countBooks();

    Book insertBook(Book book);

    Book getBookById(long id);

    List<Book> getAllBooks();

    void updateTitleById(long id, String title);

    void deleteBookById(long id);

}
