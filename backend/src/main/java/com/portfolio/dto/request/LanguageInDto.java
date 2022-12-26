package com.portfolio.dto.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class LanguageInDto implements Serializable {

    @NotNull(message = "The name cannot be null")
    @NotEmpty(message = "The name cannot be empty")
    private String name;

    @NotEmpty(message = "The certificate URL cannot be empty")
    private String certificateUrl;

    @NotNull(message = "The language level ID cannot be null")
    @Min(value = 1, message = "The language level ID cannot be less than 1")
    private Integer languageLevelId;

}
