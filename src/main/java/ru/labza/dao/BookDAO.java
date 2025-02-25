package ru.labza.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.labza.models.Book;
import ru.labza.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("select * from book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("select * from book where book_id = ?", new BeanPropertyRowMapper<>(Book.class), id)
                .stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("insert into book(title, author, year) values (?, ?, ?)",
                book.getTitle(), book.getAuthor() ,book.getYear());
    }
    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("update book set title = ?, author = ?, year = ? where book_id = ?",
                updatedBook.getTitle(), updatedBook.getAuthor(), updatedBook.getYear(), id);
    }
    public void delete(int id) {
        jdbcTemplate.update("delete from book where book_id = ?", id);
    }

    public void release(int id) {
        jdbcTemplate.update("update book set person_id = null where book_id = ?", id);
    }
    public Optional<Person> showOwner(int id) {
        return jdbcTemplate.query("select full_name from book b join person p on p.person_id = b.person_id " +
                "where book_id = ?", new BeanPropertyRowMapper<>(Person.class), id).stream().findAny();
    }
    public void assign(int book_id, Person selectedPerson) {
        jdbcTemplate.update("update book set person_id = ? where book_id = ?", selectedPerson.getPerson_id(), book_id);
    }
}
