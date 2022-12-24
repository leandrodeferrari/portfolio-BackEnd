package com.portfolio.service;

import com.portfolio.model.entity.JobExperienceType;

import java.util.List;

public interface IJobExperienceTypeService {

    List<String> getAllTypes();

    JobExperienceType findById(Integer id);

}
