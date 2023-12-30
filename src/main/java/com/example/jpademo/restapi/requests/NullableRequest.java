package com.example.jpademo.restapi.requests;

import org.openapitools.jackson.nullable.JsonNullable;

public class NullableRequest {
    public JsonNullable<String> name = JsonNullable.undefined();
}
