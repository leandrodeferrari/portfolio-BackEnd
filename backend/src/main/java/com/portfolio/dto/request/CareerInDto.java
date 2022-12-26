package com.portfolio.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CareerInDto implements Serializable {

    @NotNull(message = "The name cannot be null")
    @NotEmpty(message = "The name cannot be empty")
    private String name;

    @NotNull(message = "The start date cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotNull(message = "The is finished cannot be null")
    private boolean isFinished;

    @NotNull(message = "The approved subjects cannot be null")
    @Min(value = 0, message = "The approved subjects cannot be less than 0")
    private Byte approvedSubjects;

    @NotNull(message = "The total subjects cannot be null")
    @Min(value = 0, message = "The total subjects cannot be less than 0")
    private Byte totalSubjects;

    @NotNull(message = "The study plan URL cannot be null")
    @NotEmpty(message = "The study plan URL cannot be empty")
    private String studyPlanUrl;

    @NotNull(message = "The description cannot be null")
    @NotEmpty(message = "The description cannot be empty")
    private String description;

    @NotNull(message = "The institute or university ID cannot be null")
    @Min(value = 1, message = "The institute or university ID cannot be less than 1")
    private Integer instituteUniversityId;

    @NotNull(message = "The career type ID cannot be null")
    @Min(value = 1, message = "The career type ID cannot be less than 1")
    private Integer careerTypeId;

}
