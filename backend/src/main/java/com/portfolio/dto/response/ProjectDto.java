package com.portfolio.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProjectDto implements Serializable {

    private Integer id;
    private String name;
    private String startDate;
    private String endDate;
    private String description;
    private String imageUrl;
    private String evidenceUrl;
    private String projectTypeName;
    private BusinessDto businessDto;

}
