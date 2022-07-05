package ru.otus.jdbcboot.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.jdbcboot.domain.Book;
import ru.otus.jdbcboot.service.BookOperationsService;
import ru.otus.jdbcboot.service.IOService;

import java.util.List;

@ShellComponent
public class AppShellController {
    private final BookOperationsService bookOperationsService;
    private final IOService ioService;

    @Autowired
    public AppShellController(BookOperationsService bookOperationsService, IOService ioService) {
        this.bookOperationsService = bookOperationsService;
        this.ioService = ioService;
    }

    @ShellMethod(value = "Cоздание книги в таблице BOOKS", key = {"bc", "book creation"})
    public void askForBookCreation() {
        long id = bookOperationsService.createBook();
        Book book = bookOperationsService.getBookById(id);
        if (book != null) {
            String bookString = String.format("Книга создана ID: %d, Название: %s, Автор: %s, Жанр: %s", book.getId(), book.getTitle(), book.getAuthor(), book.getGenre());
            ioService.outputString(bookString);
        }
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
        int numberOfBooks = bookOperationsService.printNumberOfAllBooks();
        String numberOfBooksString = String.format("Количество книг в таблице = %d", numberOfBooks);
        ioService.outputString(numberOfBooksString);
    }

    @ShellMethod(value = "Показать все книги в таблице BOOKS", key = {"bl", "book list"})
    public void askForAllBooks() {
        List<Book> listOfBooks = bookOperationsService.printAllBooks();
        for (Book book : listOfBooks) {
            String bookString = String.format("Книга ID: %d, Название: %s, Автор: %s, Жанр: %s", book.getId(), book.getTitle(), book.getAuthor(), book.getGenre());
            ioService.outputString(bookString);
        }
    }

}