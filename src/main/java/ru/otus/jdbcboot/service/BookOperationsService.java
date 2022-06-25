package ru.otus.jdbcboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.jdbcboot.dao.BookDaoJdbc;

@Service
public class BookOperationsService {
    private final IOServiceStreams ioService;
    private final BookDaoJdbc bookDaoJdbc;

    //@Autowired
    public BookOperationsService(IOServiceStreams ioService, BookDaoJdbc bookDaoJdbc) {
        this.ioService = ioService;
        this.bookDaoJdbc = bookDaoJdbc;
    }

    public void deleteBookById(long id) {
        try {
            bookDaoJdbc.deleteBookById(id);
            String bookId = String.format("Книга c ID=%s удалена", id);
            ioService.outputString(bookId);
        } catch (Exception e) {
            ioService.outputString("Ошибка удаления");
        }
    }
}
