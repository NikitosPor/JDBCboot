package ru.otus.jdbcboot.repositories;

import ru.otus.jdbcboot.domain.Book;
import ru.otus.jdbcboot.domain.Comment;

import java.util.List;

public interface CommentRepository {

    long countComments();

    Comment insertComment(Comment comment);

    Comment getCommentById(long id);

    List<Comment> getAllComments();

    void updateCommentById(long id, String title);

    void deleteCommentById(long id);

}
