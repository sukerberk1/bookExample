package com.example.jpademo.domain.customer.identities;

import com.example.jpademo.addons.serialization.SerdeProvider;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;

@Component
public class CustomerIdSerializationConfig implements SerdeProvider<CustomerId> {

    @Override
    public JsonDeserializer<CustomerId> getJsonDeserializer() {
        return new JsonDeserializer<CustomerId>() {
            @Override
            public CustomerId deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
                final var value = p.getValueAsString();
                return value == null ? new CustomerId() : CustomerId.fromString(value);
            }
        };
    }

    @Override
    public JsonSerializer<CustomerId> getJsonSerializer() {
        return new JsonSerializer<CustomerId>() {
            @Override
            public void serialize(CustomerId value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                if (value == null) gen.writeNull();
                else gen.writeString(value.id().toString());
            }
        };
    }

    @Override
    public Formatter<CustomerId> getTypedFieldFormatter() {
        return new Formatter<>() {
            @Override
            public CustomerId parse(String text, Locale locale) throws ParseException {
                return CustomerId.fromString(text);
            }

            @Override
            public String print(CustomerId object, Locale locale) {
                return object.id().toString();
            }
        };
    }

    @Override
    public Class<CustomerId> getType() {
        return CustomerId.class;
    }
}
