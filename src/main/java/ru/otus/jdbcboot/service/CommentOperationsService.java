package ru.otus.jdbcboot.service;

import org.springframework.stereotype.Service;
import ru.otus.jdbcboot.domain.Comment;
import ru.otus.jdbcboot.repositories.CommentRepositoryJpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class CommentOperationsService {
    private final IOServiceStreams ioService;
    private final CommentRepositoryJpa commentRepositoryJpa;

    //@Autowired
    public CommentOperationsService(IOServiceStreams ioService, CommentRepositoryJpa commentRepositoryJpa) {
        this.ioService = ioService;
        this.commentRepositoryJpa = commentRepositoryJpa;
    }

    public Comment createComment() {
        ioService.outputString("Введите <ID_Книги;Ваш_комментарий> и нажмите Enter");
        String stringLine = ioService.readString();
        ArrayList<String> listOfStrings = new ArrayList<String>();
        Scanner scanner = new Scanner(stringLine);
        scanner.useDelimiter(";");
        while (scanner.hasNext()) {
            String data = scanner.next();
            listOfStrings.add(data);
        }
        Comment Comment = new Comment(Long.parseLong(listOfStrings.get(0)), listOfStrings.get(1));

        return commentRepositoryJpa.insertComment(Comment);
    }

    public void updateComment() {
        ioService.outputString("Введите <ID_Комментария;Ваш_комментарий> и нажмите Enter");
        String stringLine = ioService.readString();
        ArrayList<String> listOfStrings = new ArrayList<String>();
        Scanner scanner = new Scanner(stringLine);
        scanner.useDelimiter(";");
        while (scanner.hasNext()) {
            String data = scanner.next();
            listOfStrings.add(data);
        }

        commentRepositoryJpa.updateCommentById(Long.parseLong(listOfStrings.get(0)), listOfStrings.get(1));
    }

    public void deleteCommentById(long id) {
        commentRepositoryJpa.deleteCommentById(id);
    }

    public Comment getCommentById(long id) {
        return commentRepositoryJpa.getCommentById(id);
    }

    public long printNumberOfAllComments() {
        return commentRepositoryJpa.countComments();
    }

    public List<Comment> printAllComments() {
        return commentRepositoryJpa.getAllComments();
    }
}
