package ru.labza.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class Book {
    private int book_id;
    @NotEmpty (message = "title should not be empty")
    private String title;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 4, max = 40, message = "Name should be between 4 and 40 characters")
    @Pattern(regexp = "[A-Za-z]+ [A-Z][.][A-Z][.]", message = "Author must be in format: Ivanov I.I.")
    private String author;
    private int year;

    public Book() {
    }

    public Book(int book_id, String title, String author, int year) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
