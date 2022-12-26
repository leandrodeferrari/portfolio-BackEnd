package com.portfolio.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CourseInDto implements Serializable {

    @NotNull(message = "The title cannot be null")
    @NotEmpty(message = "The title cannot be empty")
    private String title;

    @NotNull(message = "The is approved cannot be null")
    private boolean isApproved;

    @NotEmpty(message = "The certificate URL cannot be empty")
    private String certificateUrl;

    @NotNull(message = "The start date cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotNull(message = "The institute or university ID cannot be null")
    @Min(value = 1, message = "The ID cannot be less than 1")
    private Integer instituteUniversityId;

}
