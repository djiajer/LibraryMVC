package ru.labza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.labza.models.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByOwner
}
