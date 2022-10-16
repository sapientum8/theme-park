package com.gradlehero.themepark;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class MapstructTest {
    @Test
    public void testMapstruct() {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1,"Jane"));
        patients.add(new Patient(2,"Jill"));
        var d = new Doctor(1,"Alex","doc",patients);
        var e = new Education("doc","NYU",1);
        DoctorDto d1 = DoctorMapper.INSTANCE.doctorToDoctorDto(d,e);
        assertEquals(d.getId(),d1.getId());
        assertEquals(d.getName(),d1.getName());
        assertEquals(e.getDegreeName(),d1.getDegree());
        assertEquals(d.getSpecialty(),d1.getSpecialization());
        assertEquals(d1.getPatientDtoList().size(),2);

        d1.setSpecialization("quack");

        DoctorMapper.INSTANCE.updateModel(d1,d);

        System.out.println(d.getSpecialty());
    }
}
