package ru.otus.jdbcboot.service;

import org.springframework.stereotype.Service;
import ru.otus.jdbcboot.dao.BookDaoJdbc;
import ru.otus.jdbcboot.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class BookOperationsService {
    private final IOServiceStreams ioService;
    private final BookDaoJdbc bookDaoJdbc;

    //@Autowired
    public BookOperationsService(IOServiceStreams ioService, BookDaoJdbc bookDaoJdbc) {
        this.ioService = ioService;
        this.bookDaoJdbc = bookDaoJdbc;
    }

    public long createBook() {
        ioService.outputString("Введите <Название книги;Автора;Жанр> без пробелов и нажмите Enter");
        String stringLine = ioService.readString();
        ArrayList<String> listOfStrings = new ArrayList<String>();
        Scanner scanner = new Scanner(stringLine);
        scanner.useDelimiter(";");
        while (scanner.hasNext()) {
            String data = scanner.next();
            listOfStrings.add(data);
        }
        Book book = new Book(1, listOfStrings.get(0), listOfStrings.get(1), listOfStrings.get(2));
        //   long id =
        return bookDaoJdbc.insertBook(book);
        //   return bookDaoJdbc.getByBookId(id);
    }

    public void deleteBookById(long id) {
            bookDaoJdbc.deleteBookById(id);
    }

    public Book getBookById(long id) {
        return bookDaoJdbc.getByBookId(id);
    }

    public int printNumberOfAllBooks() {
            return bookDaoJdbc.countBook();
    }

    public List<Book> printAllBooks() {
        return bookDaoJdbc.getAllBooks();
    }
}
