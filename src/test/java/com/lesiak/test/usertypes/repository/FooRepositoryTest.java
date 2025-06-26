package com.lesiak.test.usertypes.repository;

import jakarta.transaction.Transactional;

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
        fooRepository.deleteAll();
    }
}
