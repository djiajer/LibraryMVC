package ru.labza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.labza.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
