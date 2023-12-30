package com.example.jpademo.domain.review.identity;

import com.example.jpademo.addons.serialization.SerdeProvider;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.format.Formatter;

import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;

public class ReviewIdSerializationConfig implements SerdeProvider<ReviewId> {
    @Override
    public JsonDeserializer<ReviewId> getJsonDeserializer() {
        return new JsonDeserializer<ReviewId>() {
            @Override
            public ReviewId deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
                final var value = p.getValueAsString();
                return value == null ? new ReviewId() : ReviewId.fromString(value);
            }
        };
    }

    @Override
    public JsonSerializer<ReviewId> getJsonSerializer() {
        return new JsonSerializer<ReviewId>() {
            @Override
            public void serialize(ReviewId value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                if(value == null) gen.writeNull();
                else gen.writeString(value.id().toString());
            }
        };
    }

    @Override
    public Formatter<ReviewId> getTypedFieldFormatter() {
        return new Formatter<ReviewId>() {
            @Override
            public ReviewId parse(String text, Locale locale) throws ParseException {
                return ReviewId.fromString(text);
            }

            @Override
            public String print(ReviewId object, Locale locale) {
                return object.id().toString();
            }
        };
    }

    @Override
    public Class<ReviewId> getType() {
        return ReviewId.class;
    }
}
