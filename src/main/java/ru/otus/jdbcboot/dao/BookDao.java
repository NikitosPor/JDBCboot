package ru.otus.jdbcboot.dao;

//import ru.otus.jdbcboot.domain.Person;

import ru.otus.jdbcboot.domain.Book;
import java.util.List;

public interface BookDao {

    int countBook();
    long insertBook(Book book);
    Book getByBookId(long id);
    List<Book> getAllBooks();
    void deleteBookById(long id);

}
