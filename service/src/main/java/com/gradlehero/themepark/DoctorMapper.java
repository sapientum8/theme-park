package com.gradlehero.themepark;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);
    DoctorDto doctorToDoctorDto(Doctor doctor);
}