package com.lesiak.test.usertypes.usertypes;

import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.sql.Clob;
import java.sql.NClob;

import com.lesiak.test.usertypes.entities.FooId;
import org.hibernate.engine.jdbc.CharacterStream;
import org.hibernate.engine.jdbc.internal.CharacterStreamImpl;
import org.hibernate.type.descriptor.java.AbstractClassJavaType;
import org.hibernate.type.descriptor.java.AbstractJavaType;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.DataHelper;
import org.hibernate.type.descriptor.java.JavaType;
import org.hibernate.type.descriptor.java.StringJavaType;
import org.hibernate.type.descriptor.jdbc.JdbcType;
import org.hibernate.type.descriptor.jdbc.JdbcTypeIndicators;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;
import org.hibernate.type.descriptor.jdbc.spi.JdbcTypeRegistry;
import org.hibernate.type.spi.TypeConfiguration;


public class FooIdJavaType extends AbstractClassJavaType<FooId> {
    public static final StringJavaType INSTANCE = new StringJavaType();

    public FooIdJavaType() {
        super(FooId.class);
    }

    public boolean useObjectEqualsHashCode() {
        return true;
    }

//    public String toString(String value) {
//        return value;
//    }

    public FooId fromString(CharSequence string) {
        return new FooId(string.toString());
    }

    public JdbcType getRecommendedJdbcType(JdbcTypeIndicators stdIndicators) {
//        TypeConfiguration typeConfiguration = stdIndicators.getTypeConfiguration();
//        JdbcTypeRegistry stdRegistry = typeConfiguration.getJdbcTypeRegistry();
//        if (stdIndicators.isLob()) {
//            return stdIndicators.isNationalized() ? stdRegistry.getDescriptor(2011) : stdRegistry.getDescriptor(2005);
//        } else {
//            return stdIndicators.isNationalized() ? stdRegistry.getDescriptor(-9) : super.getRecommendedJdbcType(stdIndicators);
//        }
        return VarcharJdbcType.INSTANCE;
    }



    @Override
    public <X> X unwrap(FooId value, Class<X> type, WrapperOptions options) {
        if (value == null) {
            return null;
        } else if (String.class.isAssignableFrom(type)) {
            return (X)value.getId();
        } else if (byte[].class.isAssignableFrom(type)) {
            return (X)value.getId().getBytes(StandardCharsets.UTF_8);
        } else if (Reader.class.isAssignableFrom(type)) {
            return (X)(new StringReader(value.getId()));
        } else {
            throw this.unknownUnwrap(type);
        }
    }

    public <X> FooId wrap(X value, WrapperOptions options) {
        if (value == null) {
            return null;
        } else if (value instanceof String) {
            String string = (String)value;
            return new FooId(string);
        } else if (value instanceof char[]) {
            char[] chars = (char[])value;
            return new FooId(new String(chars));
        } else if (value instanceof byte[]) {
            byte[] bytes = (byte[])value;
            return new FooId(new String(bytes, StandardCharsets.UTF_8));

        } else if (value instanceof FooId) {
            return (FooId)value;
        }

        else {
            throw this.unknownWrap(value.getClass());
        }
    }

//    public boolean isWider(JavaType<?> javaType) {
//        boolean var10000;
//        switch (javaType.getTypeName()) {
//            case "char":
//            case "char[]":
//            case "java.lang.Character":
//            case "java.lang.Character[]":
//                var10000 = true;
//                break;
//            default:
//                var10000 = false;
//        }
//
//        return var10000;
//    }

    public <X> FooId coerce(X value, JavaType.CoercionContext coercionContext) {
        return this.wrap(value, (WrapperOptions)null);
    }
}
//
//
//public class FooIdJavaType extends AbstractJavaType<FooId> {
//
//    public static final FooIdJavaType INSTANCE = new FooIdJavaType();
//
//    public FooIdJavaType() {
//        super(FooId.class);
//    }
//
//    @Override
//    public String toString(FooId value) {
//        return value == null ? null : value.getId();
//    }
//
//    @Override
//    public FooId fromString(CharSequence string) {
//        return string == null ? null : new FooId(string.toString());
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public <X> X unwrap(FooId value, Class<X> type, WrapperOptions options) {
//        if (value == null) {
//            return null;
//        }
//        if (String.class.isAssignableFrom(type)) {
//            return (X) value.getId();
//        } else if (byte[].class.isAssignableFrom(type)) {
//            return (X) value.getId().getBytes(StandardCharsets.UTF_8);
//        }
//        throw unknownUnwrap(type);
//    }
//
//    @Override
//    public <X> FooId wrap(X value, WrapperOptions options) {
//        if (value == null) {
//            return null;
//        }
//        if (value instanceof String str) {
//            return new FooId(str);
//        }
//        if (value instanceof FooId code) {
//            return code;
//        }
//        if (value instanceof byte[] bytes) {
//            return new FooId(new String(bytes, StandardCharsets.UTF_8));
//
//        }
//        throw unknownWrap(value.getClass());
//    }
//
//
//
//}