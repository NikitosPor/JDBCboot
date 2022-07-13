package ru.otus.jdbcboot.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.jdbcboot.domain.Comment;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepositoryJpa implements CommentRepository {

    @PersistenceContext
    private final EntityManager em;

    public CommentRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional(readOnly = true)
    public long countComments() {
        Query query = em.createQuery("select count(b) from Comment b");
        return (long) query.getSingleResult();
    }

    @Override
    @Transactional
    public Comment insertComment(Comment Comment) {
        if (Comment.getId() <= 0) {
            em.persist(Comment);
        } else {
            em.merge(Comment);
        }
        return Comment;
    }

    @Override
    @Transactional(readOnly = true)
    public Comment getCommentById(long id) {
        Query query = em.createQuery("select b from Comment b where b.id= :id", Comment.class);
        query.setParameter("id", id);
        return (Comment) query.getSingleResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> getAllComments() {
        TypedQuery<Comment> query = em.createQuery("select b from Comment b", Comment.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void deleteCommentById(long id) {
        Query query = em.createQuery("delete from Comment b where b.id= :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateCommentById(long id, String title) {
        Query query = em.createQuery("update Comment b set b.comment = :comment where b.id = :id");
        query.setParameter("comment", title);
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
