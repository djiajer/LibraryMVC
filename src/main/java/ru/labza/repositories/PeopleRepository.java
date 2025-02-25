package ru.labza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.labza.models.Person;

public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
