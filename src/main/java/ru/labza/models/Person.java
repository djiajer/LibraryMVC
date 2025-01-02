package ru.labza.models;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

public class Person {
    private int person_id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 4, max = 40, message = "Name should be between 4 and 40 characters")
    @Pattern(regexp = "[A-Za-z]+ [A-Z][.][A-Z][.]", message = "Full name must be in format: Ivanov I.I.")
    private String full_name;

    @Range(min = 1900, max = 2024, message = "Date of birth should be greater than 1900 and less than 2024")
    private int date_of_birth;


    public Person() {
    }

    public Person(int person_id, String full_name, int date_of_birth) {
        this.person_id = person_id;
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
}


