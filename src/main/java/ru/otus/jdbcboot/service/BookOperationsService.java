package ru.otus.jdbcboot.service;

import org.springframework.stereotype.Service;
import ru.otus.jdbcboot.repositories.BookRepositoryJpa;
import ru.otus.jdbcboot.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class BookOperationsService {
    private final IOServiceStreams ioService;
    private final BookRepositoryJpa bookRepositoryJpa;

    //@Autowired
    public BookOperationsService(IOServiceStreams ioService, BookRepositoryJpa bookRepositoryJpa) {
        this.ioService = ioService;
        this.bookRepositoryJpa = bookRepositoryJpa;
    }

    public Book createBook() {
        ioService.outputString("Введите <Название книги;Автора;Жанр> без пробелов и нажмите Enter");
        String stringLine = ioService.readString();
        List<String> listOfStrings = new ArrayList<String>();
        Scanner scanner = new Scanner(stringLine);
        scanner.useDelimiter(";");
        while (scanner.hasNext()) {
            String data = scanner.next();
            listOfStrings.add(data);
        }
        Book book = new Book(listOfStrings.get(0), listOfStrings.get(1), listOfStrings.get(2));

        return bookRepositoryJpa.insertBook(book);
    }

    public void updateBook() {
        ioService.outputString("Введите <ID_книги;Название книги> без пробелов и нажмите Enter");
        String stringLine = ioService.readString();
        ArrayList<String> listOfStrings = new ArrayList<String>();
        Scanner scanner = new Scanner(stringLine);
        scanner.useDelimiter(";");
        while (scanner.hasNext()) {
            String data = scanner.next();
            listOfStrings.add(data);
        }

        bookRepositoryJpa.updateTitleById(Long.parseLong(listOfStrings.get(0)), listOfStrings.get(1));
    }

    public void deleteBookById(long id) {
        bookRepositoryJpa.deleteBookById(id);
    }

    public Book getBookById(long id) {
        return bookRepositoryJpa.getBookById(id);
    }

    public long printNumberOfAllBooks() {
        return bookRepositoryJpa.countBooks();
    }

    public List<Book> printAllBooks() {
        return bookRepositoryJpa.getAllBooks();
    }
}
