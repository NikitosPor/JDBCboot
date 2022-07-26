package ru.otus.jdbcboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.jdbcboot.domain.Book;

public interface BookRepository extends MongoRepository<Book, String>, BookRepositoryCustom {

}
