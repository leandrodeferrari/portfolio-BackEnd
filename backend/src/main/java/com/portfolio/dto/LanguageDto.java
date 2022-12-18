package com.portfolio.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LanguageDto implements Serializable {

    private String name;
    private String certificateUrl;
    private String languageLevelName;

}
