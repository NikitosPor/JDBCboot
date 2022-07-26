package ru.otus.jdbcboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.jdbcboot.domain.Comment;

public interface CommentRepository extends MongoRepository<Comment, String>, CommentRepositoryCustom {

}
