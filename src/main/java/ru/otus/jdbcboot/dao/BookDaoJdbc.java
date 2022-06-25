package ru.otus.jdbcboot.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.otus.jdbcboot.domain.Book;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoJdbc implements BookDao {

    private final JdbcOperations jdbc;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public BookDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.jdbc = namedParameterJdbcOperations.getJdbcOperations();
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public int count() {
        Integer count = jdbc.queryForObject("select count(*) from BOOKS", Integer.class);
        return count == null ? 0 : count;
    }

    @Override
    public void insert(Book book) {
     //   MapSqlParameterSource params = new
     //   namedParameterJdbcOperations.query();
    }

    @Override
    public Book getById(long id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("ID", id);
       return namedParameterJdbcOperations.queryForObject("select ID, TITLE, AUTHOR, GENRE from BOOKS where ID = :ID", params, new BookMapper());
    }

    @Override
    public List<Book> getAll() {
        return jdbc.query("select ID, TITLE, AUTHOR, GENRE from BOOKS", new BookMapper());
    }

    @Override
    public void deleteBookById(long id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("ID", id);
        namedParameterJdbcOperations.update("delete from BOOKS where ID = :ID", params);
    }

    private static class BookMapper implements RowMapper<Book>{
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("ID");
            String title = resultSet.getString("TITLE");
            String author = resultSet.getString("AUTHOR");
            String genre = resultSet.getString("GENRE");
            return new Book(id, title, author, genre);
        }
    }
}
