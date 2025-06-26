package com.lesiak.test.usertypes.usertypes;

import com.lesiak.test.usertypes.entities.FooId;

import org.hibernate.HibernateException;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.descriptor.converter.spi.BasicValueConverter;
import org.hibernate.type.descriptor.java.JavaType;
import org.hibernate.usertype.EnhancedUserType;


import static org.hibernate.type.SqlTypes.VARCHAR;

public class FooIdUserType implements EnhancedUserType<FooId> {
    @Override
    public int getSqlType() {
        return VARCHAR;
    }

    @Override
    public Class<FooId> returnedClass() {
        return FooId.class;
    }

    @Override
    public boolean equals(FooId x, FooId y) {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(FooId x) {
        return x.hashCode();
    }

    @Override
    public FooId nullSafeGet(ResultSet rs, int position,
                              SharedSessionContractImplementor session, Object owner)
            throws SQLException {
        String string = rs.getString( position );
        return rs.wasNull() ? null : new FooId(string);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, FooId value, int index,
                            SharedSessionContractImplementor session)
            throws SQLException {
        if ( value == null ) {
            st.setNull(index, VARCHAR);
        }
        else {
            st.setString(index, value.getId());
        }
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public FooId deepCopy(FooId value) {
        return value; //Period is immutable
    }

    @Override
    public Serializable disassemble(FooId period) {
        return period; //Period is immutable
    }

    @Override
    public FooId assemble(Serializable cached, Object owner) {
        return (FooId) cached; //Period is immutable
    }

    @Override
    public String toSqlLiteral(FooId value) {
        return value.getId();
    }

    @Override
    public String toString(FooId value) throws HibernateException {
        return value.getId();
    }

    @Override
    public FooId fromStringValue(CharSequence sequence) throws HibernateException {
        return new FooId(sequence.toString());
    }

//    @Override
//    public BasicValueConverter<FooId, Object> getValueConverter() {
//        return EnhancedUserType.super.getValueConverter();
//    }
}