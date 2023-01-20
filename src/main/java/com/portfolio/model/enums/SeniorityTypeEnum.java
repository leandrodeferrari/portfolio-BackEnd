package com.portfolio.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SeniorityTypeEnum {

    TRAINEE("Trainee"),
    JUNIOR("Junior"),
    SEMISENIOR("SemiSenior"),
    SENIOR("Senior");

    private final String name;

}
