package ru.otus.jdbcboot.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import ru.otus.jdbcboot.domain.Book;
import ru.otus.jdbcboot.domain.Comment;

import java.util.List;

@RequiredArgsConstructor
public class BookRepositoryCustomImpl implements BookRepositoryCustom {

    private final MongoTemplate mongoTemplate;
    private final CommentRepository commentRepository;

    @Override
    public void updateTitleByTitle(String oldTitle, String newTitle) {
        Query query = new Query();
        query.addCriteria(Criteria.where("title").is(oldTitle));
        Update update = new Update().set("title", newTitle);
        mongoTemplate.updateFirst(query, update, Book.class);
    }


    @Override
    public void deleteBookWithAllCommentsByTitle(String bookTitle) {
        Query queryBook = new Query(Criteria.where("title").is(bookTitle));
        try {
            List<Comment> comments = mongoTemplate.findOne(queryBook, Book.class).getComments();
            commentRepository.deleteAll(comments);
        } catch (Exception npe) {
            //нет комментов
        } finally {
            mongoTemplate.findAllAndRemove(queryBook, Book.class);
        }

    }

}