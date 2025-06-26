package com.lesiak.test.usertypes.usertypes;

import com.lesiak.test.usertypes.entities.BarId;

public class BarIdUserType extends StringConstructorUserType<BarId> {
    public BarIdUserType() {
        super(BarId.class);
    }
}
