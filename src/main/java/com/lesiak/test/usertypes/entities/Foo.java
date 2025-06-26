package com.lesiak.test.usertypes.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

import com.lesiak.test.usertypes.usertypes.FooIdUserType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Type;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;

/**
 * Entity class for Foo, using FooId as its embedded key.
 */
@Entity
@Table(name = "foos")
@Data
@NoArgsConstructor
public class Foo {

    @Id
    //@Type(FooIdUserType.class)
    @Convert(converter = FooIdConverter.class) //
    private FooId fooId;

    @Column(name = "name") // Define the column name
    private String name;

    @OneToMany(mappedBy = "foo", fetch = EAGER, orphanRemoval = true, cascade = ALL)
    @BatchSize(size = 10)
    private Set<FooProgress> progressEntities = new HashSet<>();



    public Foo(FooId fooId, String name) {
        this.fooId = fooId;
        this.name = name;
    }

    public void addProgressEntity(FooProgress progress) {
        this.progressEntities.add(progress);
        progress.setFoo(this); // Ensure bidirectional relationship is maintained
    }

}