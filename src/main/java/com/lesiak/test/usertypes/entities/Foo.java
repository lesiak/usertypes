package com.lesiak.test.usertypes.entities;

import jakarta.persistence.*;

import com.lesiak.test.usertypes.usertypes.FooIdUserType;
import org.hibernate.annotations.Type;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;

/**
 * Entity class for Foo, using FooId as its embedded key.
 */
@Entity
@Table(name = "foos")
public class Foo {

    @Id
    @Type(FooIdUserType.class)
    private FooId fooId;

    @Column(name = "name") // Define the column name
    private String name;

    @OneToOne(mappedBy = "foo", fetch = EAGER, orphanRemoval = true, cascade = ALL)
    private FooProgress fooProgress;

    // No-arg constructor required by JPA
    public Foo() {
    }

    public Foo(FooId fooId, String name, FooProgress fooProgress) {
        this.fooId = fooId;
        this.name = name;
        this.fooProgress = fooProgress;
    }

    public FooId getFooId() {
        return fooId;
    }

    public void setFooId(FooId id) {
        this.fooId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FooProgress getFooProgress() {
        return fooProgress;
    }

    public void setFooProgress(FooProgress fooProgress) {
        this.fooProgress = fooProgress;
        if (fooProgress != null) {
            fooProgress.setFoo(this);
        }
    }

    @Override
    public String toString() {
        return "Foo{" +
               "id=" + fooId +
               ", name='" + name + '\'' +
               '}';
    }
}