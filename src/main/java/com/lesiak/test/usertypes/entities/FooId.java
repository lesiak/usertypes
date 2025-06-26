package com.lesiak.test.usertypes.entities;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FooId implements StringWrapper, Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @Override
    public String getValue() {
        return id;
    }

}