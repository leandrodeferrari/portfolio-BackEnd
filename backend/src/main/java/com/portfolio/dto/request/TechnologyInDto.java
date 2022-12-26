package com.portfolio.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class TechnologyInDto implements Serializable {

    @NotNull(message = "The name cannot be null")
    @NotEmpty(message = "The name cannot be empty")
    private String name;

    @NotNull(message = "The logo URL cannot be null")
    @NotEmpty(message = "The logo URL cannot be empty")
    private String logoUrl;

}
