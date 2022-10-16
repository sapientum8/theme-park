package com.gradlehero.themepark;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {PatientMapper.class})
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    @Mapping(target = "specialization", source = "doctor.specialty")
    @Mapping(target = "degree", source = "education.degreeName")
    @Mapping(target = "patientDtoList", source = "doctor.patientList")
    DoctorDto doctorToDoctorDto(Doctor doctor,Education education);

    @Mapping(source = "doctorDto.patientDtoList", target = "patientList")
    @Mapping(source = "doctorDto.specialization", target = "specialty")
    void updateModel(DoctorDto doctorDto, @MappingTarget Doctor doctor);
}