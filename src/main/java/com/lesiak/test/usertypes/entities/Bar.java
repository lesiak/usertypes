package com.lesiak.test.usertypes.entities;

import jakarta.persistence.*;

import com.lesiak.test.usertypes.usertypes.BarIdUserType;
import org.hibernate.annotations.Type;

/**
 * Entity class for Bar, using BarId as its key.
 */
@Entity
@Table(name = "bars")
public class Bar {

    @Id
    @Type(BarIdUserType.class)
    private BarId id;

    @Column(name = "name") // Define the column name
    private String name;

    // No-arg constructor required by JPA
    public Foo() {
    }

    public Bar(BarId id, String name) {
        this.id = id;
        this.name = name;
    }

    public BarId getId() {
        return id;
    }

    public void setId(BarId id) {
        this.id = id;
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
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}