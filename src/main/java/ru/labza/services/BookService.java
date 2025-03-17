package ru.labza.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.labza.models.Book;
import ru.labza.models.Person;
import ru.labza.repositories.BookRepository;

import java.util.Collections;
import java.util.Date;
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
        return bookRepository.findAll(Sort.by("year"));
    }

    public Book findOne(int id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    @Transactional
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        Book bookToBeUpdated = bookRepository.findById(id).get();

        updatedBook.setBook_id(id);
        updatedBook.setOwner(bookToBeUpdated.getOwner());

        bookRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public void release(int id) {
        Book book = bookRepository.findById(id).get();
        book.setOwner(null);
        book.setAssigned_at(null);
    }

    public Optional<Person> showOwner(int id) {
        return Optional.ofNullable(bookRepository.findById(id).get().getOwner());
    }

    @Transactional
    public void assign(int book_id, Person selectedPerson) {
        bookRepository.findById(book_id).get().setOwner(selectedPerson);
        bookRepository.findById(book_id).get().setAssigned_at(new Date());
    }
    public List<Book> findAllOnPage(int page, int itemsPerPage) {
        return bookRepository.findAll(PageRequest.of(page, itemsPerPage, Sort.by("year"))).getContent();
    }

    public List<Book> searchByTitle(String s) {
        if (s.isBlank()) return Collections.emptyList();
        return bookRepository.findByTitleStartingWithIgnoreCase(s);
    }
}
