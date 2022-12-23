package com.portfolio.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CareerInDto implements Serializable {

    @NotNull(message = "The name cannot be null")
    @NotBlank(message = "The name cannot be blank")
    private String name;

    @NotNull(message = "The start date cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotNull(message = "The is finished cannot be null")
    private boolean isFinished;

    @NotNull(message = "The approved subjects cannot be null")
    private Byte approvedSubjects;

    @NotNull(message = "The total subjects cannot be null")
    private Byte totalSubjects;

    @NotNull(message = "The study plan Url cannot be null")
    @NotBlank(message = "The study plan Url cannot be blank")
    private String studyPlanUrl;

    @NotNull(message = "The description cannot be null")
    @NotBlank(message = "The description cannot be blank")
    private String description;

    @NotNull(message = "The institute or university ID cannot be null")
    private Integer instituteUniversityId;

    @NotNull(message = "The career type ID cannot be null")
    private Integer careerTypeId;

}
