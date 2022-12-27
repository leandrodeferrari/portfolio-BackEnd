package com.portfolio.dto.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Data
public class InstituteUniversityInDto implements Serializable {

    @NotNull(message = "The name cannot be null")
    @NotEmpty(message = "The name cannot be empty")
    private String name;

    @NotEmpty(message = "The logo URL cannot be empty")
    private String logoUrl;

    @NotNull(message = "The address ID cannot be null")
    @Min(value = 1, message = "The address ID cannot be less than 1")
    private Integer addressId;

}
