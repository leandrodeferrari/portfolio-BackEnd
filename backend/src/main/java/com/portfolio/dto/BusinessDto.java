package com.portfolio.dto;

import lombok.Data;

@Data
public class BusinessDto {

    private Integer id;
    private String name;
    private String logoUrl;
    private AddressDto addressDto;

}
