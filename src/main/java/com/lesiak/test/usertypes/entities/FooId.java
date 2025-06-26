package com.lesiak.test.usertypes.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FooId implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

}