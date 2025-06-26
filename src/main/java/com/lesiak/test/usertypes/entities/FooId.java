package com.lesiak.test.usertypes.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

public class FooId implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;


    public FooId( ) {

    }

    public FooId(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FooId fooId = (FooId) o;
        return Objects.equals(id, fooId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "FooId{" +
               "value=" + id +
               '}';
    }
}