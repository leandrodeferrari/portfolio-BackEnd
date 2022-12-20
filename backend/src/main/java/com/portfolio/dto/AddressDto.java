package com.portfolio.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressDto implements Serializable {

    private Integer id;
    private String cityName;
    private String localityName;
    private String provinceName;
    private String countryName;

}
