package ru.labza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.labza.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<List<Book>> findByTitleStartingWith(String s);
}
