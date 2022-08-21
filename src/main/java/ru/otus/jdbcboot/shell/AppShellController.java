package ru.otus.jdbcboot.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.jdbcboot.domain.Book;
import ru.otus.jdbcboot.domain.Comment;
import ru.otus.jdbcboot.service.BookOperationsService;
import ru.otus.jdbcboot.service.CommentOperationsService;
import ru.otus.jdbcboot.service.IOService;

import java.util.List;

@ShellComponent
public class AppShellController {
    private final CommentOperationsService commentOperationsService;
    private final BookOperationsService bookOperationsService;
    private final IOService ioService;

    @Autowired
    public AppShellController(BookOperationsService bookOperationsService, CommentOperationsService commentOperationsService, IOService ioService) {
        this.bookOperationsService = bookOperationsService;
        this.commentOperationsService = commentOperationsService;
        this.ioService = ioService;
    }

    /////////////////////////////////////////BOOKS SHELL///////////////////////////////////////////////////////////////////////////////////////

    @ShellMethod(value = "Cоздание книги в таблице BOOKS", key = {"bc", "book creation"})
    public void askForBookCreation() {
        Book book = bookOperationsService.createBook();
        String bookString = String.format("Книга создана ID: %d, Название: %s, Автор: %s, Жанр: %s", book.getId(), book.getTitle(), book.getAuthor(), book.getGenre());
        ioService.outputString(bookString);
    }

    @ShellMethod(value = "Обновление книги в таблице BOOKS", key = {"bu", "book update"})
    public void askForBookUpdate() {
        bookOperationsService.updateBook();
        String bookString = String.format("Книга обновлена");
        ioService.outputString(bookString);
    }

    @ShellMethod(value = "Удаление книги в таблице BOOKS по ID", key = {"bd", "book deletion"})
    public void askForBookDeletion(long id) {
        bookOperationsService.deleteBookById(id);
        String bookIdString = String.format("Книга c ID: %s удалена", id);
        ioService.outputString(bookIdString);
    }

    @ShellMethod(value = "Просмотр книги в таблице BOOKS по ID", key = {"bs", "book search"})
    public void askForBookById(long id) {
        Book book = bookOperationsService.getBookById(id);
        String bookString = String.format("Книга ID: %d, Название: %s, Автор: %s, Жанр: %s", book.getId(), book.getTitle(), book.getAuthor(), book.getGenre());
        ioService.outputString(bookString);
    }

    @ShellMethod(value = "Узнать количество книг в таблице BOOKS", key = {"ba", "book amount"})
    public void askForBookAmount() {
        long numberOfBooks = bookOperationsService.printNumberOfAllBooks();
        String numberOfBooksString = String.format("Количество книг в таблице = %d", numberOfBooks);
        ioService.outputString(numberOfBooksString);
    }

    @ShellMethod(value = "Показать все книги в таблице BOOKS", key = {"bl", "book list"})
    public void askForAllBooks() {
        List<Book> listOfBooks = bookOperationsService.printAllBooks();
        for (Book book : listOfBooks) {
            if (book.getComments().size() == 0) {
                String bookString = String.format("Книга ID: %d, Название: %s, Автор: %s, Жанр: %s", book.getId(), book.getTitle(), book.getAuthor(), book.getGenre());
                ioService.outputString(bookString);
            }
            for (Comment comment : book.getComments()) {
                String bookString = String.format("Книга ID: %d, Название: %s, Автор: %s, Жанр: %s, Комментарий: %s", book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(), comment.getComment());
                ioService.outputString(bookString);
            }
        }
    }
/////////////////////////////////////////////////COMMENTS SHELL//////////////////////////////////////////////////////////////////////////////////////////

    @ShellMethod(value = "Cоздание комментария в таблице COMMENTS", key = {"cc", "comment creation"})
    public void askForCommentCreation() {
        Comment comment = commentOperationsService.createComment();
        String commentString = String.format("Создан комментарий: %s, c ID: %d", comment.getComment(), comment.getId());
        ioService.outputString(commentString);
    }

    @ShellMethod(value = "Обновление комментария в таблице Comments", key = {"cu", "comment update"})
    public void askForCommentUpdate() {
        commentOperationsService.updateComment();
        String сommentString = String.format("Комментарий обновлен");
        ioService.outputString(сommentString);
    }

    @ShellMethod(value = "Удаление комментария в таблице Comments по ID", key = {"cd", "comment deletion"})
    public void askForCommentDeletion(long id) {
        commentOperationsService.deleteCommentById(id);
        String сommentIdString = String.format("Комментарий c ID: %d удален", id);
        ioService.outputString(сommentIdString);
    }

    @ShellMethod(value = "Просмотр комментария в таблице Comments по ID", key = {"cs", "comment search"})
    public void askForCommentById(long id) {
        Comment comment = commentOperationsService.getCommentById(id);
        String commentString = String.format("Комментарий: %s, c ID: %d", comment.getComment(), comment.getId());
        ioService.outputString(commentString);
    }

    @ShellMethod(value = "Узнать количество комментариев в таблице Comments", key = {"ca", "comment amount"})
    public void askForCommentAmount() {
        long numberOfComments = commentOperationsService.printNumberOfAllComments();
        String numberOfCommentsString = String.format("Количество комментариев в таблице = %d", numberOfComments);
        ioService.outputString(numberOfCommentsString);
    }

    @ShellMethod(value = "Показать все комментарии в таблице Comments", key = {"cl", "comment list"})
    public void askForAllComments() {
        List<Comment> listOfComments = commentOperationsService.printAllComments();
        for (Comment comment : listOfComments) {
            String commentString = String.format("ID: %d, : %s, BOOK_ID: %d", comment.getId(), comment.getComment(), comment.getBookId());
            ioService.outputString(commentString);
        }
    }


}