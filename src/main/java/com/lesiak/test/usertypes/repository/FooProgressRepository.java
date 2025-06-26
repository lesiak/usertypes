package com.lesiak.test.usertypes.repository;

import com.lesiak.test.usertypes.entities.Foo;
import com.lesiak.test.usertypes.entities.FooId;
import com.lesiak.test.usertypes.entities.FooProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Foo entity.
 * Extends JpaRepository, specifying the entity type (Foo) and its ID type (FooId).
 */
@Repository
public interface FooProgressRepository extends JpaRepository<FooProgress, FooId> {
    // Spring Data JPA automatically provides common CRUD operations.
    // You can add custom query methods here if needed, e.g.:
    // List<Foo> findByName(String name);
}