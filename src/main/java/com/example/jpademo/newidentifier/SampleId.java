package com.example.jpademo.newidentifier;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = false)
@Value
public class SampleId extends UuidBasedIdentifier{
}
