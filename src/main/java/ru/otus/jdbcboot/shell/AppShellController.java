package ru.otus.jdbcboot.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import ru.otus.jdbcboot.service.BookOperationsService;

import java.util.Objects;

@ShellComponent
public class AppShellController {
    private final BookOperationsService bookOperationsService;

    @Autowired
    public AppShellController(BookOperationsService bookOperationsService) {
        this.bookOperationsService = bookOperationsService;
    }

    @ShellMethod(value = "Cоздание книги в таблице BOOKS", key = {"bc", "book creation"})
    public void askForBookCreation() {
        bookOperationsService.createBook();
    }

    @ShellMethod(value = "Удаление книги в таблице BOOKS по ID", key = {"bd", "book deletion"})
    public void askForBookDeletion(long id) {
        bookOperationsService.deleteBookById(id);
    }

    @ShellMethod(value = "Просмотр книги в таблице BOOKS по ID", key = {"bs", "book search"})
    public void askForBookById(long id) {
        bookOperationsService.getBookById(id);
    }

    @ShellMethod(value = "Узнать количество книг в таблице BOOKS", key = {"ba", "book amount"})
    public void askForBookCount() {
        bookOperationsService.printNumberOfAllBooks();
    }

    @ShellMethod(value = "Показать все книги в таблице BOOKS", key = {"bl", "book list"})
    public void askForAllBooks() {
        bookOperationsService.printAllBooks();
    }

//    @ShellMethod(value = "Test initiation", key = {"e", "exam"})
//    @ShellMethodAvailability(value = "isConfirmationReceived")
//    public String askForTestStart(String studentSolution) throws Exception {
//        if (Objects.equals(studentSolution, "start")) {
//            app.run();
//            return "Тест завершен";
//        } else {
//            return "Если хотите запустить тест сначала, то введите команду 'e start'";
//        }
//    }
//
//    private Availability isConfirmationReceived() {
//        return Objects.equals(personalInfoUsageConfirmation, "yes")
//                ? Availability.available()
//                : Availability.unavailable("Сначала подтвердите ваше согласие на обработку персональных данных, вызвав команду 'c yes'");
//    }
}