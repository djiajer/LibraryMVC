package ru.labza.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.labza.models.Book;
import ru.labza.models.Person;
import ru.labza.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findOne(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        updatedBook.setBook_id(id);
        bookRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Transactional      // maybe need to save()
    public void release(int id) {
        Book book = bookRepository.findById(id).get();
        book.setOwner(null);
    }

    public Optional<Person> showOwner(int id) {
        return Optional.ofNullable(bookRepository.findById(id).get().getOwner());
    }

    @Transactional      // maybe need to save()
    public void assign(int book_id, Person selectedPerson) {
        bookRepository.findById(book_id).get().setOwner(selectedPerson);
    }
}
