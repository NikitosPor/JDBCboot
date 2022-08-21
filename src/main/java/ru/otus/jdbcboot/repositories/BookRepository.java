package ru.otus.jdbcboot.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.jdbcboot.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Modifying
    @Query("update Book b set b.title = :title where b.id = :id")
    void updateTitleById(@Param("id") long id, @Param("title") String title);

}
