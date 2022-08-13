package ru.otus.jdbcboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.jdbcboot.domain.Author;

public interface AuthorRepository extends MongoRepository<Author, Long> {

}
