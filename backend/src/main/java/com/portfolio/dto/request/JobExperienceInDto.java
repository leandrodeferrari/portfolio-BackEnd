package com.portfolio.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class JobExperienceInDto implements Serializable {

    @NotNull(message = "The name cannot be null")
    @NotEmpty(message = "The name cannot be empty")
    private String name;

    @NotNull(message = "The start date cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotNull(message = "The is current job cannot be null")
    private boolean isCurrentJob;

    @NotNull(message = "The description cannot be null")
    @NotEmpty(message = "The description cannot be empty")
    private String description;

    @NotNull(message = "The seniority type ID cannot be null")
    @Min(value = 1, message = "The seniority type ID cannot be less than 1")
    private Integer seniorityTypeId;

    @NotNull(message = "The job experience type ID cannot be null")
    @Min(value = 1, message = "The job experience type ID cannot be less than 1")
    private Integer jobExperienceTypeId;

    @Min(value = 1, message = "The business ID cannot be less than 1")
    private Integer businessId;

}
