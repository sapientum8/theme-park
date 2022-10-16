package com.gradlehero.themepark;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);
    PatientDto toDto(Patient patient);
}