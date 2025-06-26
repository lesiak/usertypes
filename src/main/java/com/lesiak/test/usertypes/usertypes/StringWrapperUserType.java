package com.lesiak.test.usertypes.usertypes;

import com.lesiak.test.usertypes.entities.StringWrapper;
import io.hypersistence.utils.hibernate.type.DescriptorImmutableType;
import org.hibernate.HibernateException;

import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

public abstract class StringWrapperUserType<X extends StringWrapper>
        extends DescriptorImmutableType<X, VarcharJdbcType, StringWrapperJavaType<X>>
        {

    public StringWrapperUserType(Class<X> clazz) {
        super(clazz, VarcharJdbcType.INSTANCE, new StringWrapperJavaType<>(clazz));
    }

    @Override
    public X fromStringValue(CharSequence sequence) throws HibernateException {
        return getExpressibleJavaType().wrap(sequence, null);
    }



}

