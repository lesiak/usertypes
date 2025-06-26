package com.lesiak.test.usertypes.entities;

import jakarta.persistence.AttributeConverter;

public class FooIdConverter implements AttributeConverter<FooId, String> {

    @Override
    public String convertToDatabaseColumn(FooId fooId) {
        if (fooId == null) {
            return null;
        }
        return fooId.getId();
    }

    @Override
    public FooId convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return new FooId(dbData);
    }
}
