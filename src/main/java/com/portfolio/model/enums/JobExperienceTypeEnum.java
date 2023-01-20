package com.portfolio.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JobExperienceTypeEnum {

    FREELANCE("Freelance"),
    CONTRACTOR("Contractor"),
    DEPENDENCY_RELATIONSHIP("En relación de dependencia");

    private final String name;

}
