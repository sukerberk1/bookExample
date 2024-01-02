package com.example.jpademo.newidentifier;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class DifferentId extends UuidBasedIdentifier{
}
