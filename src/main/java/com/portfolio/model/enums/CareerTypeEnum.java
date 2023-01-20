package com.portfolio.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CareerTypeEnum {

    ASSOCIATE_DEGREE("Tecnicatura"),
    ENGINEERING("Ingeniería"),
    BACHELORS_DEGREE("Licenciatura");

    private final String name;

}
