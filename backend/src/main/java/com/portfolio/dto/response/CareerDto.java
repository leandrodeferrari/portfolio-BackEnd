package com.portfolio.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class CareerDto implements Serializable {

    private Integer id;
    private String name;
    private String startDate;
    private String endDate;
    private boolean isFinished;
    private Byte approvedSubjects;
    private Byte totalSubjects;
    private String studyPlanUrl;
    private String description;
    private InstituteUniversityDto instituteUniversityDto;
    private String careerTypeName;

}
