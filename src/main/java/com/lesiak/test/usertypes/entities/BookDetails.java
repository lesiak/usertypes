package com.lesiak.test.usertypes.entities;

import jakarta.persistence.*;

import jakarta.persistence.*;

@Entity
@Table(name = "book_details")
public class BookDetails {

    @Id // The ID of BookDetails will be the same as the Book's ID
    private Long id;

    @Column(name = "summary", length = 1000)
    private String summary;

    @Column(name = "number_of_pages")
    private Integer numberOfPages;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId // This indicates that 'id' of BookDetails is derived from 'book'
    @JoinColumn(name = "id") // <-- *** THIS IS THE KEY CHANGE ***
    // This tells JPA that the 'id' column in 'book_details'
    // serves as BOTH its primary key AND the foreign key
    // referencing the 'books' table's 'id' column.
    private Book book;

    // Constructors
    public BookDetails() {
    }

    public BookDetails(Long id, String summary, Integer numberOfPages) {
        this.id = id;
        this.summary = summary;
        this.numberOfPages = numberOfPages;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
        // When the book is set, the ID of this BookDetails instance
        // will eventually be populated by JPA from the associated Book's ID.
        // You generally don't set this.id directly here when using @MapsId,
        // JPA handles it during persist.
    }

    @Override
    public String toString() {
        return "BookDetails{" +
               "id=" + id +
               ", summary='" + summary + '\'' +
               ", numberOfPages=" + numberOfPages +
               '}';
    }
}