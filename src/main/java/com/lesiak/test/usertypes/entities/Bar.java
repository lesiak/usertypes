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
    private BarId barId;

    @Column(name = "name") // Define the column name
    private String name;

    // No-arg constructor required by JPA
    public Foo() {
    }

    public Bar(BarId id, String name) {
        this.barId = id;
        this.name = name;
    }

    public BarId getBarId() {
        return barId;
    }

    public void setBarId(BarId barId) {
        this.barId = barId;
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
               "barId=" + barId +
               ", name='" + name + '\'' +
               '}';
    }
}