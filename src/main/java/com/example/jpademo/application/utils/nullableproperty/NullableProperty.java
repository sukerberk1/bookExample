package com.example.jpademo.application.utils.nullableproperty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(using = NullablePropertyDeserializer.class)
@JsonSerialize(using = NullablePropertySerializer.class)
public class NullableProperty<T> {
    private final T value;
    private boolean present = false;

    public NullableProperty(T value) {
        this.value = value;
        present = true;
    }

}
