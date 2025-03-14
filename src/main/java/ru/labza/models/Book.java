package ru.labza.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int book_id;

    @ManyToOne
    @JoinColumn(name = "person_id_fk", referencedColumnName = "person_id")
    private Person owner;
    @NotEmpty (message = "title should not be empty")
    @Column(name = "title")
    private String title;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 4, max = 40, message = "Name should be between 4 and 40 characters")
    @Pattern(regexp = "[A-Za-z]+ [A-Z][.][A-Z][.]", message = "Author must be in format: Ivanov I.I.")
    @Column(name = "author")
    private String author;
    @Column(name = "year")
    private int year;

    @Column(name = "assigned_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assigned_at;

    @Transient
    private boolean isOverdue;

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

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Date getAssigned_at() {
        return assigned_at;
    }

    public void setAssigned_at(Date assigned_at) {
        this.assigned_at = assigned_at;
    }

    public boolean isOverdue() {
        return isOverdue;
    }

    public void setOverdue(boolean overdue) {
        isOverdue = overdue;
    }

    public void updateOverdue() {
        long overdueTime = (24 * 60 * 60 * 1000) * 10; // (1 day) * number of days
        this.setOverdue(new Date().getTime()           //current time
                - this.getAssigned_at().getTime()      //assigned time
                > overdueTime);
    }
}
