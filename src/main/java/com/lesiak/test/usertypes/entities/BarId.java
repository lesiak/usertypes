package com.lesiak.test.usertypes.entities;


import java.io.Serializable;
import java.util.Objects;


public class BarId implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;


    public BarId(String value) {
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
        BarId barId = (BarId) o;
        return Objects.equals(id, barId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BarId{" +
               "value=" + id +
               '}';
    }
}