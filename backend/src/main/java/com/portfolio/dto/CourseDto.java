package com.portfolio.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CourseDto implements Serializable {

    private Integer id;
    private String title;
    private boolean isApproved;
    private String certificateUrl;
    private String startDate;
    private String endDate;
    private InstituteUniversityDto instituteUniversityDto;

}
