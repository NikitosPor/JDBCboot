package ru.otus.jdbcboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "BOOKS")
@NamedEntityGraph(name = "book-comments-entity-graph", attributeNodes = {@NamedAttributeNode("comments")})
public final class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "TITLE", nullable = false, unique = true)
    private String title;

    @Column(name = "AUTHOR", nullable = false)
    private String author;

    @Column(name = "GENRE", nullable = false)
    private String genre;

    @OneToMany(targetEntity = Comment.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "BOOK_ID")
    private List<Comment> comments;

    public Book(long id, String title, String author, String genre) {
        this.id=id;
        this.title=title;
        this.author=author;
        this.genre=genre;
    }

    public Book(String title, String author, String genre) {
        this.id=-1;
        this.title=title;
        this.author=author;
        this.genre=genre;
    }

    long getId(){
        return id;
    }
}
