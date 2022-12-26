package com.portfolio.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AddressInDto implements Serializable {

    @NotNull(message = "The city name cannot be null")
    @NotEmpty(message = "The city name cannot be empty")
    private String cityName;

    @NotNull(message = "The locality name cannot be null")
    @NotEmpty(message = "The locality name cannot be empty")
    private String localityName;

    @NotEmpty(message = "The province name cannot be empty")
    private String provinceName;

    @NotNull(message = "The country name cannot be null")
    @NotEmpty(message = "The country name cannot be empty")
    private String countryName;

}
