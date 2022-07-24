package ru.otus.jdbcboot.repositories;

public interface BookRepositoryCustom {

    void updateTitleById(long id, String title);

}
