package ru.otus.jdbcboot.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import lombok.val;
import ru.otus.jdbcboot.domain.Author;
import ru.otus.jdbcboot.domain.Book;
import ru.otus.jdbcboot.domain.Comment;
import ru.otus.jdbcboot.domain.Genre;
import ru.otus.jdbcboot.repositories.AuthorRepository;
import ru.otus.jdbcboot.repositories.BookRepository;
import ru.otus.jdbcboot.repositories.CommentRepository;
import ru.otus.jdbcboot.repositories.GenreRepository;

import java.util.Arrays;


@ChangeLog(order = "001")
public class InitMongoDBDataChangeLog {

    private Author author_1;
    private Author author_2;
    private Author author_3;
    private Author author_4;
    private Author author_5;

    private Genre genre_1;
    private Genre genre_2;
    private Genre genre_3;

    private Comment comment_1;
    private Comment comment_2;
    private Comment comment_3;
    private Comment comment_4;
    private Comment comment_5;
    private Comment comment_6;
    private Comment comment_7;


    @ChangeSet(order = "000", id = "dropDB", author = "np", runAlways = true)
    public void dropDB(MongoDatabase database) {
        database.drop();
    }

    @ChangeSet(order = "001", id = "initAuthor", author = "np", runAlways = true)
    public void initAuthors(AuthorRepository repository) {
        Author author_1 = repository.save(new Author("Leo Tolstoy"));
        Author author_2 = repository.save(new Author("Alex Pushkin"));
        Author author_3 = repository.save(new Author("Michael Sholokhov"));
        Author author_4 = repository.save(new Author("Arthur Conan Doyle"));
        Author author_5 = repository.save(new Author("Nikolay Gogol"));
    }

    @ChangeSet(order = "002", id = "initGenre", author = "np", runAlways = true)
    public void initGenres(GenreRepository repository) {
        Genre genre_1 = repository.save(new Genre("Tale"));
        Genre genre_2 = repository.save(new Genre("Drama"));
        Genre genre_3 = repository.save(new Genre("Detective"));
    }

    @ChangeSet(order = "003", id = "initComment", author = "np", runAlways = true)
    public void initComments(CommentRepository repository) {
        Comment comment_1 = repository.save(new Comment("Good example of traditional Russian culture"));
        Comment comment_2 = repository.save(new Comment("One of the most epic drama in the world"));
        Comment comment_3 = repository.save(new Comment("Leo Tolstoy wrote it when he was old boy"));
        Comment comment_4 = repository.save(new Comment("Famous literature composition"));
        Comment comment_5 = repository.save(new Comment("One of the most epic drama in the world"));
        Comment comment_6 = repository.save(new Comment("Alex Pushkin wrote it when he was young boy"));
        Comment comment_7 = repository.save(new Comment("Russian pupils learn it in school"));
    }


    @ChangeSet(order = "004", id = "initBooks", author = "np", runAlways = true)
    public void initBooks(BookRepository repository) {
        repository.save(new Book("War and peace", author_1, genre_2, comment_1, comment_2, comment_3 ));
        repository.save(new Book("Eugene Onegin", author_2, genre_2, comment_4, comment_5, comment_6, comment_7 ));
        repository.save(new Book("Kazaks", author_1, genre_1 ));
        repository.save(new Book("Silent Don", author_3, genre_2 ));
        repository.save(new Book("Sherlock Holmes", author_4, genre_3 ));
        repository.save(new Book("Taras Bulba", author_5, genre_2 ));
    }





//    @ChangeSet(order = "002", id = "initStudents", author = "np", runAlways = true)
//    public void initStudents(StudentRepository repository) {
////        repository.save(new Student("Student #1", springDataKnowledge, mongockKnowledge));
//    }
//
//    @ChangeSet(order = "003", id = "Teacher", author = "np", runAlways = true)
//    public void initTeachers(TeacherRepository repository) {
////        val teacher = new Teacher("Teacher #1", springDataKnowledge, mongockKnowledge, aggregationApiKnowledge);
////        repository.save(teacher);
//    }
}
