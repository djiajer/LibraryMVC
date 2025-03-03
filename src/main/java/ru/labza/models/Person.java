package ru.labza.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int person_id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 4, max = 40, message = "Name should be between 4 and 40 characters")
    @Pattern(regexp = "[A-Za-z]+ [A-Z][.][A-Z][.]", message = "Full name must be in format: Ivanov I.I.")
    @Column(name = "full_name")
    private String full_name;

    @Range(min = 1900, max = 2024, message = "Date of birth should be greater than 1900 and less than 2024")
    @Column(name = "date_of_birth")
    private int date_of_birth;

    @OneToMany(mappedBy = "owner")
    List<Book> personsBooks;


    public Person() {
    }

    public Person(String full_name, int date_of_birth) {
        this.full_name = full_name;
        this.date_of_birth = date_of_birth;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(int date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "full_name='" + full_name + '\'' +
                ", date_of_birth=" + date_of_birth +
                '}';
    }
}


