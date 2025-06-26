package com.lesiak.test.usertypes.entities;

import jakarta.persistence.*;


import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "foo_progress")
@Data
@EqualsAndHashCode(exclude = "foo")
@ToString(exclude = "foo")
@NoArgsConstructor
@AllArgsConstructor
public class FooProgress {

    @Id
    private String id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "foo_id")
    private Foo foo;

}