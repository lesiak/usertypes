package com.lesiak.test.usertypes.entities;

import jakarta.persistence.*;

import com.lesiak.test.usertypes.usertypes.FooIdUserType;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "foo_progress")
public class FooProgress {

    @Id
    //@Type(FooIdUserType.class)
    //private FooId fooId;
    private String fooId;

    @Column(name = "name") // Define the column name
    private String name;

    @OneToOne(optional = false)
    @MapsId("fooId")
   // @JoinColumn(name = "foo_id")
    private Foo foo;

    // No-arg constructor required by JPA
    public FooProgress() {
    }

    public FooProgress(String id, String name, Foo foo) {
        this.fooId = id;
        this.name = name;
        this.foo = foo;
    }

    public String getFooId() {
        return fooId;
    }

    public void setFooId(String fooId) {
        this.fooId = fooId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }

    @Override
    public String toString() {
        return "FooProgress{" +
               "fooId=" + fooId +
               ", name='" + name + '\'' +
               '}';
    }
}