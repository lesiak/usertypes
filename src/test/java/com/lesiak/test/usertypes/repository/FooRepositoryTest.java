package com.lesiak.test.usertypes.repository;

import jakarta.transaction.Transactional;

import com.lesiak.test.usertypes.entities.Foo;
import com.lesiak.test.usertypes.entities.FooId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@Transactional
public class FooRepositoryTest {
    @Autowired
    private FooRepository fooRepository;

    @Test
    void aaa() {
        fooRepository.save(new Foo(new FooId("1"), "foo1"));
        fooRepository.save(new Foo(new FooId("2"), "foo2"));
        fooRepository.findAll().forEach(System.out::println);
    }
}
