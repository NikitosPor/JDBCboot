package ru.otus.jdbcboot.repositories;

import ru.otus.jdbcboot.domain.Comment;

public interface CommentRepositoryCustom {

    void updateCommentById(String id, String title);

    Comment insertCommentAndLinkWithBookByTitle(String title, String comment);

}
