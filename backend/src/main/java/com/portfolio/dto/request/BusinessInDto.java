package com.portfolio.dto.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class BusinessInDto implements Serializable {

    @NotNull(message = "The name cannot be null")
    @NotBlank(message = "The name cannot be blank")
    private String name;

    @NotBlank(message = "The logo URL cannot be blank")
    private String logoUrl;

    @NotNull(message = "The address ID cannot be null")
    @Min(value = 1, message = "The address ID cannot be less than 1")
    private Integer addressId;

}
