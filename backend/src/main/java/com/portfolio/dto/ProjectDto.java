package com.portfolio.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProjectDto implements Serializable {

    private String name;
    private String startDate;
    private String endDate;
    private String description;
    private String imageUrl;
    private String evidenceUrl;
    private String projectTypeName;
    private BusinessDto businessDto;

}
