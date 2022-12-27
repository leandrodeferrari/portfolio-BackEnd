package com.portfolio.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProjectTypeEnum {

    OWN("Propio"),
    ACCELERATION("Aceleración");

    private final String name;

}
