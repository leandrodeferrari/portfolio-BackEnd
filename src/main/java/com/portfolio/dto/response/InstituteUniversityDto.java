package com.portfolio.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class InstituteUniversityDto implements Serializable {

    private Integer id;
    private String name;
    private String logoUrl;
    private AddressDto addressDto;

}
