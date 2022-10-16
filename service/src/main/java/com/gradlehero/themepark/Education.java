package com.gradlehero.themepark;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Education {
    private String degreeName;
    private String institute;
    private Integer yearOfPassing;
}