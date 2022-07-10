package ru.otus.jdbcboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="COMMENTS")
public final class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "BOOK_ID", nullable = false)
    private long book_id;

    @Column(name = "COMMENT", nullable = false)
    private String comment;

    public Comment(long book_id, String comment) {
        this.book_id=book_id;
        this.comment=comment;
    }
}