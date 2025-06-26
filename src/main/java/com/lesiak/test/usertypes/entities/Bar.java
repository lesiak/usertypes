package com.lesiak.test.usertypes.entities;

import jakarta.persistence.*;

import com.lesiak.test.usertypes.usertypes.FooIdUserType;
import org.hibernate.annotations.Type;

/**
 * Entity class for Bar, using BarId as its key.
 */
@Entity
@Table(name = "bars")
public class Bar {

    @Id
    @Type(FooIdUserType.class)
    private FooId fooId;

    @Column(name = "name") // Define the column name
    private String name;

    // No-arg constructor required by JPA
    public Bar() {
    }

    public Bar(FooId id, String name) {
        this.fooId = id;
        this.name = name;
    }

    public FooId getFooId() {
        return fooId;
    }

    public void setFooId(FooId fooId) {
        this.fooId = fooId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bar{" +
               "fooId=" + fooId +
               ", name='" + name + '\'' +
               '}';
    }
}