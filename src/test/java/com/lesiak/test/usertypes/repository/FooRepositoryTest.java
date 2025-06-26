package com.lesiak.test.usertypes.repository;

import jakarta.transaction.Transactional;

import javax.sql.DataSource;

import java.util.List;

import com.lesiak.test.usertypes.entities.Foo;
import com.lesiak.test.usertypes.entities.FooId;
import com.lesiak.test.usertypes.entities.FooProgress;
//import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import io.zonky.test.db.postgres.embedded.EmbeddedPostgres;
import io.zonky.test.db.postgres.junit5.EmbeddedPostgresExtension;
import io.zonky.test.db.postgres.junit5.SingleInstancePostgresExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TestTransaction;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {EmbeddedPostgresConfiguration.class})
public class FooRepositoryTest {


    @Autowired
    private FooRepository fooRepository;

    @Test
    @Transactional
    void aaa() throws Exception {

        var fooId1 = new FooId("1");
        var fooId2 = new FooId("2");
        var fooProgress1 = new FooProgress("p1", "foo1Progress", null);
        var fooProgress2 = new FooProgress("p2", "foo2Progress", null);

        var foo1 = new Foo(fooId1, "foo1");
        var foo2 = new Foo(fooId2, "foo2");
        foo1.addProgressEntity(fooProgress1);
        foo1.addProgressEntity(fooProgress2);
        fooRepository.save(foo1);
        fooRepository.save(foo2);


        // Commit the first transaction
        TestTransaction.flagForCommit(); // Mark the current test transaction for commit
        TestTransaction.end();

        TestTransaction.start();

        List<Foo> all = fooRepository.findAll();
        all.forEach(System.out::println);
    }

}
