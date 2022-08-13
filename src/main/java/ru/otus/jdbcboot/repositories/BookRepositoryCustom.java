package ru.otus.jdbcboot.repositories;

public interface BookRepositoryCustom {

    void updateTitleByTitle(String id, String title);

    void deleteBookWithAllCommentsByTitle(String id);

}
