package ru.otus.jdbcboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.jdbcboot.domain.Book;

public interface BookRepository extends MongoRepository<Book, Long>, BookRepositoryCustom {

//    @Modifying
//    @Transactional
//    @Query("update Book b set b.title = :title where b.id = :id")
//    void updateTitleById(@Param("id") long id, @Param("title") String title);

}
