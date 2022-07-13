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

        return commentRepository.save(Comment);
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

        commentRepository.updateCommentById(Long.parseLong(listOfStrings.get(0)), listOfStrings.get(1));
    }

    public void deleteCommentById(long id) {
        commentRepository.deleteById(id);
    }

    public Optional<Comment> getCommentById(long id) {
        return commentRepository.findById(id);
    }

    public long printNumberOfAllComments() {
        return commentRepository.count();
    }

    public List<Comment> printAllComments() {
        return (List<Comment>) commentRepository.findAll();
    }
}
