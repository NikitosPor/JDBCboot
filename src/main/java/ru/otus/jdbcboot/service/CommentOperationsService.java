package ru.otus.jdbcboot.service;

import org.springframework.stereotype.Service;
import ru.otus.jdbcboot.domain.Comment;
import ru.otus.jdbcboot.repositories.CommentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CommentOperationsService {
    private final IOServiceStreams ioService;
    private final CommentRepository commentRepository;

    //@Autowired
    public CommentOperationsService(IOServiceStreams ioService, CommentRepository commentRepository) {
        this.ioService = ioService;
        this.commentRepository = commentRepository;
    }

    public Comment createComment() {
        ioService.outputString("Введите <Название_Книги;Ваш_комментарий> и нажмите Enter");
        String stringLine = ioService.readString();
        ArrayList<String> listOfStrings = new ArrayList<String>();
        Scanner scanner = new Scanner(stringLine);
        scanner.useDelimiter(";");
        while (scanner.hasNext()) {
            String data = scanner.next();
            listOfStrings.add(data);
        }
        // Comment Comment = new Comment(/*Long.parseLong(listOfStrings.get(0)),*/ listOfStrings.get(1));

        return commentRepository.insertCommentAndLinkWithBookByTitle(listOfStrings.get(0), listOfStrings.get(1));
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

        commentRepository.updateCommentById(listOfStrings.get(0), listOfStrings.get(1));
    }

    public void deleteCommentById(String id) {
        commentRepository.deleteById(id);
    }

    public Optional<Comment> getCommentById(String id) {
        return commentRepository.findById(id);
    }

    public long printNumberOfAllComments() {
        return commentRepository.count();
    }

    public List<Comment> printAllComments() {
        return commentRepository.findAll();
    }
}
