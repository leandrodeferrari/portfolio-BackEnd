package com.portfolio.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class JobExperienceDto implements Serializable {

    private Integer id;
    private String name;
    private String startDate;
    private String endDate;
    private boolean isCurrentJob;
    private String description;
    private String seniorityName;
    private String jobExperienceTypeName;
    private BusinessDto businessDto;

}
