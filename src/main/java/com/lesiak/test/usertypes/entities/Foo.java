package com.lesiak.test.usertypes.entities;

import jakarta.persistence.*;

import com.lesiak.test.usertypes.usertypes.FooIdUserType;
import org.hibernate.annotations.Type;

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

    // No-arg constructor required by JPA
    public Foo() {
    }

    public Foo(FooId fooId, String name) {
        this.fooId = fooId;
        this.name = name;
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

    @Override
    public String toString() {
        return "Foo{" +
               "id=" + fooId +
               ", name='" + name + '\'' +
               '}';
    }
}