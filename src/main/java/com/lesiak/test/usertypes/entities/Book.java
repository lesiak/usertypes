package com.lesiak.test.usertypes.entities;

import jakarta.persistence.*;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY; // Often LAZY is preferred for parent side

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;

    @OneToOne(mappedBy = "book", cascade = ALL, fetch = EAGER, orphanRemoval = true)
    private BookDetails details;

    // Constructors
    public Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BookDetails getDetails() {
        return details;
    }

    // Important: Keep the bidirectional relationship consistent
    public void setDetails(BookDetails details) {
        if (details == null) {
            if (this.details != null) {
                this.details.setBook(null);
            }
        } else {
            details.setBook(this);
        }
        this.details = details;
    }

    @Override
    public String toString() {
        return "Book{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", author='" + author + '\'' +
               '}';
    }
}