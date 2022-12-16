package com.portfolio.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class JobExperienceDto implements Serializable {

    private String name;
    private String startDate;
    private String endDate;
    private boolean isCurrentJob;
    private String description;
    private String seniorityName;
    private String jobExperienceName;
    private BusinessDto businessDto;

}
