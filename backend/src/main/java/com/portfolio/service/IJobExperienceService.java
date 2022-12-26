package com.portfolio.service;

import com.portfolio.dto.request.JobExperienceInDto;
import com.portfolio.dto.response.JobExperienceDto;

import java.util.List;

public interface IJobExperienceService {

    List<JobExperienceDto> getAll();
    void delete(Integer id);
    JobExperienceDto create(JobExperienceInDto jobExperienceInDto);
    JobExperienceDto update(JobExperienceInDto jobExperienceInDto, Integer id);

}
