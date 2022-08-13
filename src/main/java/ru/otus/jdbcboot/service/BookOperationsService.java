package ru.otus.jdbcboot.service;

import org.springframework.stereotype.Service;
import ru.otus.jdbcboot.domain.Author;
import ru.otus.jdbcboot.domain.Book;
import ru.otus.jdbcboot.domain.Genre;
import ru.otus.jdbcboot.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class BookOperationsService {
    private final IOServiceStreams ioService;
    private final BookRepository bookRepository;

    //@Autowired
    public BookOperationsService(IOServiceStreams ioService, BookRepository bookRepository) {
        this.ioService = ioService;
        this.bookRepository = bookRepository;
    }

    public Book createBook() {
        ioService.outputString("Введите <Название книги;Автора;Жанр> без пробелов и нажмите Enter");
        String stringLine = ioService.readString();
        ArrayList<String> listOfStrings = new ArrayList<String>();
        Scanner scanner = new Scanner(stringLine);
        scanner.useDelimiter(";");
        while (scanner.hasNext()) {
            String data = scanner.next();
            listOfStrings.add(data);
        }
        Book book = new Book(listOfStrings.get(0), new Author(listOfStrings.get(1)), new Genre(listOfStrings.get(2)));

        return bookRepository.insert(book);
    }

    public void updateBook() {
        ioService.outputString("Введите <Старое_название_книги;Новое_название_книги> и нажмите Enter");
        String stringLine = ioService.readString();
        ArrayList<String> listOfStrings = new ArrayList<String>();
        Scanner scanner = new Scanner(stringLine);
        scanner.useDelimiter(";");
        while (scanner.hasNext()) {
            String data = scanner.next();
            listOfStrings.add(data);
        }

        bookRepository.updateTitleByTitle(listOfStrings.get(0), listOfStrings.get(1));
    }

    public String deleteBookByTitle() {
        ioService.outputString("Введите <Название книги> и нажмите Enter");
        String stringLine = ioService.readString();
        bookRepository.deleteBookWithAllCommentsByTitle(stringLine);

        return stringLine;
    }

    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    public long printNumberOfAllBooks() {
        return bookRepository.count();
    }

    public List<Book> printAllBooks() {
        return bookRepository.findAll();
    }
}
