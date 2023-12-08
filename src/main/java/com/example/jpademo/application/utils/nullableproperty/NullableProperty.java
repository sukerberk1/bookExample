package com.example.jpademo.application.utils.nullableproperty;

import lombok.Getter;

public class NullableProperty<TProperty> {

    TProperty property = null;
    @Getter
    boolean overwrite = false;

    public NullableProperty()
    { }

    public NullableProperty(TProperty property)
    {
        this.property = property;
        overwrite = true;
    }

    public TProperty get()
    {
        return property;
    }
}
