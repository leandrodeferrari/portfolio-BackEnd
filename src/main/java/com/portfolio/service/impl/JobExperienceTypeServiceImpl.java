package com.portfolio.service.impl;

import com.portfolio.model.entity.JobExperienceType;
import com.portfolio.repository.IJobExperienceTypeRepository;
import com.portfolio.service.IJobExperienceTypeService;
import com.portfolio.util.ValidationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceTypeServiceImpl implements IJobExperienceTypeService {

    private final IJobExperienceTypeRepository jobExperienceTypeRepository;

    @Autowired
    public JobExperienceTypeServiceImpl(IJobExperienceTypeRepository jobExperienceTypeRepository){
        this.jobExperienceTypeRepository = jobExperienceTypeRepository;
    }

    @Override
    public List<String> getAllTypes() {
        return jobExperienceTypeRepository.findAll()
                .stream()
                .map(JobExperienceType::getName)
                .toList();
    }

    @Override
    public JobExperienceType findById(Integer id) {

        ValidationUtil.validateId(id);

        return jobExperienceTypeRepository.findById(id).orElseThrow();

    }

}
