package com.portfolio.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AddressInDto implements Serializable {

    @NotNull(message = "The city name cannot be null")
    @NotBlank(message = "The city name cannot be blank")
    private String cityName;

    @NotNull(message = "The locality name cannot be null")
    @NotBlank(message = "The locality name cannot be blank")
    private String localityName;

    @NotBlank(message = "The province name cannot be blank")
    private String provinceName;

    @NotNull(message = "The country name cannot be null")
    @NotBlank(message = "The country name cannot be blank")
    private String countryName;

}
