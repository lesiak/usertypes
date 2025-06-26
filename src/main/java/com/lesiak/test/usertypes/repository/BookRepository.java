package com.lesiak.test.usertypes.repository;

import com.lesiak.test.usertypes.entities.Book;
import com.lesiak.test.usertypes.entities.Foo;
import com.lesiak.test.usertypes.entities.FooId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>  {
}
