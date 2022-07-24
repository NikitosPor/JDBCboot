package ru.otus.jdbcboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.jdbcboot.domain.Author;

public interface AuthorRepository extends MongoRepository<Author, Long> {

//    @Modifying
//    @Transactional
//    @Query("update Comment c set c.comment = :comment where c.id = :id")
//    void updateCommentById(@Param("id") long id, @Param("comment") String comment);

}
