package com.lesiak.test.usertypes.repository;

import jakarta.transaction.Transactional;

import com.lesiak.test.usertypes.entities.Foo;
import com.lesiak.test.usertypes.entities.FooId;
import com.lesiak.test.usertypes.entities.FooProgress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@Transactional
public class FooRepositoryTest {
    @Autowired
    private FooRepository fooRepository;

    @Autowired
    private FooProgressRepository fooProgressRepository;

    @Test
    void aaa() {
        var fooId1 = new FooId("1");
        var fooId2 = new FooId("2");
        FooProgress fooProgress1 = new FooProgress(fooId1, "foo1Progress", null);
        FooProgress fooProgress2 = new FooProgress(fooId2, "foo2Progress", null);

        var foo1 = new Foo(fooId1, "foo1", null);
        var foo2 = new Foo(fooId2, "foo2", null);
        foo1.setFooProgress(fooProgress1);
        foo2.setFooProgress(fooProgress2);
        fooRepository.save(foo1);
        fooRepository.save(foo2);
        fooProgressRepository.save(fooProgress1);
        fooProgressRepository.save(fooProgress2);


        fooRepository.findAll().forEach(System.out::println);
        fooProgressRepository.findAll().forEach(System.out::println);
    }

    void aaa(Foo foo) {
        System.out.println("Foo: " + foo);
        System.out.println("Foo Progress: " + foo.getFooProgress());
    }
        // This method is intentionally left empty.
        // It can be used for further testing or assertions if needed.
}
