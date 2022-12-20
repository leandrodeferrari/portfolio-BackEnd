package com.portfolio.dto;

import lombok.Data;

@Data
public class InstituteUniversityDto {

    private Integer id;
    private String name;
    private String logoUrl;
    private AddressDto addressDto;

}
