package com.portfolio.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ProjectInDto implements Serializable {

    @NotNull(message = "The name cannot be null")
    @NotBlank(message = "The name cannot be blank")
    private String name;

    @NotNull(message = "The start date cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "The end date cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotNull(message = "The description cannot be null")
    @NotBlank(message = "The description cannot be blank")
    private String description;

    @NotBlank(message = "The image URL cannot be blank")
    private String imageUrl;

    @NotNull(message = "The evidence URL cannot be null")
    @NotBlank(message = "The evidence URL cannot be blank")
    private String evidenceUrl;

    @NotNull(message = "The project type ID cannot be null")
    @Min(value = 1, message = "The project type ID cannot be less than 1")
    private Integer projectTypeId;

    @Min(value = 1, message = "The business ID cannot be less than 1")
    private Integer businessId;

}
