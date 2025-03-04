package ru.labza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.labza.models.Book;
import ru.labza.models.Person;

import java.util.List;

public interface PeopleRepository extends JpaRepository<Person, Integer> {

}
