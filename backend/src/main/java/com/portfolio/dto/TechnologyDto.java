package com.portfolio.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TechnologyDto implements Serializable {

    private Integer id;
    private String name;
    private String logoUrl;

}
