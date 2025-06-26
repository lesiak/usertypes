package com.lesiak.test.usertypes.usertypes;

import com.lesiak.test.usertypes.entities.FooId;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractClassJavaType;





public class FooIdTypeDescriptor extends AbstractClassJavaType<FooId> {
    public static final FooIdTypeDescriptor INSTANCE = new FooIdTypeDescriptor();

    public FooIdTypeDescriptor() {
        super(FooId.class);
    }

    public <X> X unwrap(FooId value, Class<X> type, WrapperOptions options) {
        if (value == null) {
            return null;
        } else if (String.class.isAssignableFrom(type)) {
            return (X)value.getValue();
        } else {
            throw this.unknownUnwrap(type);
        }
    }

    public <X> FooId wrap(X value, WrapperOptions options) {
        if (value == null) {
            return null;
        } else if (value instanceof String) {
            return new FooId((String)value);
        } else {
            throw this.unknownWrap(value.getClass());
        }
    }
}
