package com.lesiak.test.usertypes.entities;



import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Embeddable ID class for the Bar entity.
 * It's crucial for composite primary keys or when you want a custom ID type.
 *
 * Requirements for an @Embeddable ID class:
 * 1. Must implement Serializable.
 * 2. Must have a no-arg constructor.
 * 3. Must override equals() and hashCode() based on its fields.
 */
@Embeddable
public class BarId implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    // No-arg constructor required by JPA
    public BarId() {
    }

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