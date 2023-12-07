package com.example.jpademo.application.utils.nullableproperty;

public class NullableProperty<TProperty> {
    TProperty property = null;
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
