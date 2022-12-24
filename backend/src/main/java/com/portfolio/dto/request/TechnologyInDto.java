package com.portfolio.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class TechnologyInDto implements Serializable {

    @NotNull(message = "The name cannot be null")
    @NotBlank(message = "The name cannot be blank")
    private String name;

    @NotNull(message = "The logo URL cannot be null")
    @NotBlank(message = "The logo URL cannot be blank")
    private String logoUrl;

}
