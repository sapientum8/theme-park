package com.gradlehero.themepark;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Doctor {
    private int id;
    private String name;
    private String specialty;
    private List<Patient> patientList;
}