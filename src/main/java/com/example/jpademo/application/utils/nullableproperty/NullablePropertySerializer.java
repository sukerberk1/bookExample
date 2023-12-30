package com.example.jpademo.application.utils.nullableproperty;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class NullablePropertySerializer extends JsonSerializer<NullableProperty<?>> {
    @Override
    public void serialize(NullableProperty<?> nullableProperty, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (nullableProperty.isPresent()) {
            jsonGenerator.writeObject(nullableProperty.getValue());
        } else {
            jsonGenerator.writeNull();
        }
    }
}