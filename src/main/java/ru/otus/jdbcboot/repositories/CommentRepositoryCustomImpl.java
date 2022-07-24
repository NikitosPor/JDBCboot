package ru.otus.jdbcboot.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import ru.otus.jdbcboot.domain.Book;

@RequiredArgsConstructor
public class CommentRepositoryCustomImpl implements CommentRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public void updateCommentById(long id, String comment) {
        Query query = new Query();
        query.addCriteria(Criteria.where("$id").is(id));
        Update update = new Update();
        update.set("title", comment);
        mongoTemplate.updateFirst(query, update, Book.class);
    }


//    @Override
//    public List<Knowledge> getTeacherExperienceById(String teacherId) {
//        val aggregation = newAggregation(
//                match(Criteria.where("id").is(teacherId))
//                , unwind("experience")
//                , project().andExclude("_id").and("experience.id").as("_id").and("experience.name").as("name")
//        );
//        return mongoTemplate.aggregate(aggregation, Teacher.class, Knowledge.class).getMappedResults();
//    }
}
