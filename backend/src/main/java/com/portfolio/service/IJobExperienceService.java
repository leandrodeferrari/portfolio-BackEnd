package com.portfolio.service;

import com.portfolio.dto.response.JobExperienceDto;

import java.util.List;

public interface IJobExperienceService {

    List<JobExperienceDto> getAll();

    void delete(Integer id);

}
