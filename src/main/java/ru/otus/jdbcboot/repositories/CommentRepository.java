package ru.otus.jdbcboot.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.jdbcboot.domain.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    @Modifying
    @Transactional
    @Query("update Comment c set c.comment = :comment where c.id = :id")
    void updateCommentById(@Param("id") long id, @Param("comment") String comment);

}
