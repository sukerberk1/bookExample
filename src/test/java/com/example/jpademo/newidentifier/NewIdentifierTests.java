package com.example.jpademo.newidentifier;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NewIdentifierTests {
    @Test
    public void newIdTest(){
        SampleId sampleId = new SampleId();
        assertNotNull(sampleId.id);
    }

    @Test
    public void idEqualsTest() {
        UUID uuid = UUID.randomUUID();
        SampleId sampleId = new SampleId();
        SampleId sampleId1 = new SampleId();
        sampleId.id = uuid;
        sampleId1.id = uuid;
        assertEquals(sampleId, sampleId1);
    }

}
