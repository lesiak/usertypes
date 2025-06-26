package com.lesiak.test.usertypes.usertypes;

import com.lesiak.test.usertypes.entities.FooId;

public class FooIdUserType extends StringWrapperUserType<FooId> {
    public FooIdUserType() {
        super(FooId.class);
    }
}
