package ru.otus.jdbcboot.dao;

//import ru.otus.jdbcboot.domain.Person;

import ru.otus.jdbcboot.domain.Book;
import java.util.List;

public interface BookDao {

    int count();
    void insert(Book book);
    Book getById(long id);
    List<Book> getAll();
    void deleteBookById(long id);

}
