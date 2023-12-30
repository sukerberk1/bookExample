package com.example.jpademo.application.utils.nullableproperty;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class NullablePropertyDeserializer<T> extends JsonDeserializer<NullableProperty<T>> {
    private final Class<T> type;

    public NullablePropertyDeserializer(T type) {
        this.type = (Class<T>) type.getClass();
    }

    public NullablePropertyDeserializer()
    {
        this.type = null;
    }
    @Override
    public NullableProperty<T> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.currentToken() == null) {
            return new NullableProperty<>(null);
        }
        return new NullableProperty<>(jsonParser.readValueAs(type));
    }
}