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

    public void createBook() {
        ioService.outputString("Введите <Название книги;Автора;Жанр> без пробелов и нажмите Enter");
        String stringLine = ioService.readString();
        ArrayList<String> listOfStrings = new ArrayList<String>();
        Scanner scanner = new Scanner(stringLine);
        scanner.useDelimiter(";");
        while (scanner.hasNext()) {
            String data = scanner.next();
            listOfStrings.add(data);
        }
        try {
            Book book = new Book(1, listOfStrings.get(0), listOfStrings.get(1), listOfStrings.get(2));
            long id = bookDaoJdbc.insertBook(book);
            String bookString = String.format("Книга создана ID: %d, Название: %s, Автор: %s, Жанр: %s", id, book.getTitle(), book.getAuthor(), book.getGenre());
            ioService.outputString(bookString);
        } catch (Exception e) {
            ioService.outputString("Ошибка создания книги");
        }
    }

    public void deleteBookById(long id) {
        try {
            bookDaoJdbc.deleteBookById(id);
            String bookIdString = String.format("Книга c ID: %s удалена", id);
            ioService.outputString(bookIdString);
        } catch (Exception e) {
            ioService.outputString("Ошибка удаления");
        }
    }

    public void getBookById(long id) {
        try {
            Book book = bookDaoJdbc.getByBookId(id);
            String bookString = String.format("Книга ID: %d, Название: %s, Автор: %s, Жанр: %s", book.getId(), book.getTitle(), book.getAuthor(), book.getGenre());
            ioService.outputString(bookString);

        } catch (Exception e) {
            ioService.outputString("Ошибка");
        }
    }

    public void printNumberOfAllBooks() {
        try {
            int numberOfBooks = bookDaoJdbc.count();
            String numberOfBooksString = String.format("Количество книг в таблице = %d", numberOfBooks);
            ioService.outputString(numberOfBooksString);
        } catch (Exception e) {
            ioService.outputString("Произошла ошибка");
        }
    }

    public void printAllBooks() {
        try {
            List<Book> listOfBooks = bookDaoJdbc.getAllBooks();
            for (Book book : listOfBooks) {
                String bookString = String.format("Книга ID: %d, Название: %s, Автор: %s, Жанр: %s", book.getId(), book.getTitle(), book.getAuthor(), book.getGenre());
                ioService.outputString(bookString);
            }
        } catch (Exception e) {
            ioService.outputString("Произошла ошибка");
        }
    }
}
