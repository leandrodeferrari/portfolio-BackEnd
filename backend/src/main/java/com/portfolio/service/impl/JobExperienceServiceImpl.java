package com.portfolio.service.impl;

import com.portfolio.dto.JobExperienceDto;
import com.portfolio.mapper.IJobExperienceMapper;
import com.portfolio.repository.IJobExperienceRepository;
import com.portfolio.service.IJobExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobExperienceServiceImpl implements IJobExperienceService {

    private final IJobExperienceMapper jobExperienceMapper;
    private final IJobExperienceRepository jobExperienceRepository;

    @Autowired
    public JobExperienceServiceImpl(IJobExperienceMapper jobExperienceMapper,
                                    IJobExperienceRepository jobExperienceRepository){
        this.jobExperienceMapper = jobExperienceMapper;
        this.jobExperienceRepository = jobExperienceRepository;
    }

    @Override
    public List<JobExperienceDto> getAll() {
        return jobExperienceRepository.findAll()
                .stream()
                .map(jobExperienceMapper::jobExperienceToJobExperienceDto)
                .collect(Collectors.toList());
    }

}
