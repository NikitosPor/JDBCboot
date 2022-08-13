package ru.otus.jdbcboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.jdbcboot.domain.Genre;

public interface GenreRepository extends MongoRepository<Genre, Long> {

}
