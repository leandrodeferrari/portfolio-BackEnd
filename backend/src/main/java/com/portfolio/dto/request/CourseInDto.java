package com.portfolio.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CourseInDto implements Serializable {

    @NotNull(message = "The title cannot be null")
    @NotBlank(message = "The title cannot be blank")
    private String title;

    @NotNull(message = "The is approved cannot be null")
    private boolean isApproved;

    @NotBlank(message = "The certificate URL cannot be blank")
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
