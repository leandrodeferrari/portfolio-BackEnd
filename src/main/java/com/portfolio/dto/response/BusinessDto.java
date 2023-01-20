package com.portfolio.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class BusinessDto implements Serializable {

    private Integer id;
    private String name;
    private String logoUrl;
    private AddressDto addressDto;

}
