package com.lesiak.test.usertypes.usertypes;

import com.lesiak.test.usertypes.entities.FooId;
import io.hypersistence.utils.hibernate.type.DescriptorImmutableType;
import org.hibernate.HibernateException;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

public class FooIdUserType2 extends DescriptorImmutableType<FooId, VarcharJdbcType, FooIdTypeDescriptor> {
    public FooIdUserType2() {
        super(FooId.class, VarcharJdbcType.INSTANCE, FooIdTypeDescriptor.INSTANCE);
    }

    public FooId fromStringValue(CharSequence sequence) throws HibernateException {
        return (FooId)this.getExpressibleJavaType().wrap(sequence, (WrapperOptions)null);
    }
}

