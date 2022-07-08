package ru.otus.jdbcboot.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.jdbcboot.domain.Book;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryJpa implements BookRepository {

    @PersistenceContext
    private final EntityManager em;

    public BookRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional(readOnly = true)
    public long countBook() {
        Query query = em.createQuery("select count(b) from Book b");
        return (long) query.getSingleResult();
    }

    @Override
    @Transactional
    public Book insertBook(Book book) {
        if (book.getId() <= 0) {
            em.persist(book);
        } else {
            em.merge(book);
        }
        return book;
    }

    @Override
    @Transactional(readOnly = true)
    public Book getBookById(long id) {
        Query query = em.createQuery("select b from Book b where b.id= :id", Book.class);
        query.setParameter("id", id);
        return (Book) query.getSingleResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        EntityGraph<?> entityGraph = em.getEntityGraph("book-comments-entity-graph");
        TypedQuery<Book> query = em.createQuery("select b from Book b", Book.class);
        query.setHint("javax.persistence.fetchgraph", entityGraph);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void deleteBookById(long id) {
        Query query = em.createQuery("delete from Book b where b.id= :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateTitleById(long id, String title) {
        Query query = em.createQuery("update Book b set b.title = :title where b.id = :id");
        query.setParameter("title", title);
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
