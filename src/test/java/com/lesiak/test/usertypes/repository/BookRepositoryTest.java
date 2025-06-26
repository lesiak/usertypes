package com.lesiak.test.usertypes.repository;

import jakarta.transaction.Transactional;

import java.util.List;

import com.lesiak.test.usertypes.entities.Book;
import com.lesiak.test.usertypes.entities.BookDetails;
import com.lesiak.test.usertypes.entities.Foo;
import com.lesiak.test.usertypes.entities.FooId;
import com.lesiak.test.usertypes.entities.FooProgress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@Transactional
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;


    @Test
    void aaa() {
        Book book1 = new Book("t1", "a1");
        Book book2 = new Book("t2", "a2");

        BookDetails bookDetails1 = new BookDetails("sum1", 100);
        BookDetails bookDetails2 = new BookDetails("sum2", 200);

        book1.setDetails(bookDetails1);
        book2.setDetails(bookDetails2);


        bookRepository.save(book1);
        bookRepository.save(book2);


        List<Book> all = bookRepository.findAll();
        all.forEach(System.out::println);
    }

    void aaa(Foo foo) {
        System.out.println("Foo: " + foo);
        System.out.println("Foo Progress: " + foo.getFooProgress());
    }
        // This method is intentionally left empty.
        // It can be used for further testing or assertions if needed.
}
