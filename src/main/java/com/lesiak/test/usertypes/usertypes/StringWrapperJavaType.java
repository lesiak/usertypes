package com.lesiak.test.usertypes.usertypes;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.lesiak.test.usertypes.entities.StringWrapper;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractClassJavaType;

class StringWrapperJavaType<X extends StringWrapper> extends AbstractClassJavaType<X> {

    private final Class<X> clazz;
    private final Constructor<X> constructor;


    public StringWrapperJavaType(Class<X> clazz) {
        super(clazz);
        try {
            this.clazz = clazz;
            this.constructor = clazz.getConstructor(String.class);
        } catch (NoSuchMethodException | SecurityException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public <Y> Y unwrap(X value, Class<Y> type, WrapperOptions options) {
        if (value == null) {
            return null;
        }

        if (String.class.isAssignableFrom(type)) {
            return (Y) convertToDatabaseColumn(value);
        }

        if (clazz.isAssignableFrom(type)) {
            return (Y) value;
        }

        throw unknownUnwrap(type);
    }

    @Override
    public <Y> X wrap(Y value, WrapperOptions options) {
        if (value == null) {
            return null;
        }

        if (value instanceof String valueAsString) {
            return convertFromDatabaseColumn(valueAsString);
        }

        if (clazz.isInstance(value)) {
            return (X) value;
        }

        throw unknownWrap(value.getClass());
    }

    private String convertToDatabaseColumn(X domainObject) {
        if (domainObject == null) {
            return null;
        }

        return domainObject.getValue();
    }

    private X convertFromDatabaseColumn(String valueAsString) {
        if (valueAsString == null) {
            return null;
        }

        try {
            return constructor.newInstance(valueAsString);
        } catch (InvocationTargetException e) {
            throw new IllegalStateException("Instance of class " + clazz + " cannot be created from String " + valueAsString, e);
        } catch (Exception e) {
            throw new IllegalStateException("Class " + clazz + " does not have String arg constructor", e);
        }
    }
}
