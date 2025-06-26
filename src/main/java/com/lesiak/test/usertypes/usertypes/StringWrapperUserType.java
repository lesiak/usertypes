package com.lesiak.test.usertypes.usertypes;

import com.lesiak.test.usertypes.entities.StringWrapper;
import io.hypersistence.utils.hibernate.type.DescriptorImmutableType;
import org.hibernate.HibernateException;
import org.hibernate.cache.MutableCacheKeyBuilder;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.descriptor.java.JavaTypedExpressible;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

public abstract class StringWrapperUserType<X extends StringWrapper>
        extends DescriptorImmutableType<X, VarcharJdbcType, StringWrapperJavaType<X>>
        implements JavaTypedExpressible<X> {

    public StringWrapperUserType(Class<X> clazz) {
        super(clazz, VarcharJdbcType.INSTANCE, new StringWrapperJavaType<>(clazz));
    }

    @Override
    public X fromStringValue(CharSequence sequence) throws HibernateException {
        return getExpressibleJavaType().wrap(sequence, null);
    }

    @Override
    public void addToCacheKey(MutableCacheKeyBuilder cacheKey, Object value, SharedSessionContractImplementor session) {
        if ( value == null ) {
            cacheKey.addValue( null );
            cacheKey.addHashCode( 0 );
        } else {
            cacheKey.addValue(value);
            cacheKey.addHashCode(value.hashCode());
        }
    }

}

