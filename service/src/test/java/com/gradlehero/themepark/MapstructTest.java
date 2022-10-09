package com.gradlehero.themepark;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapstructTest {
    @Test
    public void testMapstruct() {
        var d = new Doctor(1,"Alex");
        DoctorDto d1 = DoctorMapper.INSTANCE.doctorToDoctorDto(d);
        assertEquals(d.getId(),d1.getId());
        assertEquals(d.getName(),d1.getName());
    }
}
