package com.portfolio.service.impl;

import com.portfolio.dto.request.JobExperienceInDto;
import com.portfolio.dto.response.JobExperienceDto;
import com.portfolio.mapper.IJobExperienceMapper;
import com.portfolio.model.entity.JobExperience;
import com.portfolio.repository.IJobExperienceRepository;
import com.portfolio.service.*;
import com.portfolio.util.PersonUtil;
import com.portfolio.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobExperienceServiceImpl implements IJobExperienceService {

    private final IBusinessService businessService;
    private final IJobExperienceMapper jobExperienceMapper;
    private final IJobExperienceRepository jobExperienceRepository;
    private final IJobExperienceTypeService jobExperienceTypeService;
    private final IPersonService personService;
    private final ISeniorityTypeService seniorityTypeService;

    @Autowired
    public JobExperienceServiceImpl(IBusinessService businessService,
                                    IJobExperienceMapper jobExperienceMapper,
                                    IJobExperienceRepository jobExperienceRepository,
                                    IJobExperienceTypeService jobExperienceTypeService,
                                    IPersonService personService,
                                    ISeniorityTypeService seniorityTypeService){
        this.businessService = businessService;
        this.jobExperienceMapper = jobExperienceMapper;
        this.jobExperienceRepository = jobExperienceRepository;
        this.jobExperienceTypeService = jobExperienceTypeService;
        this.personService = personService;
        this.seniorityTypeService = seniorityTypeService;
    }

    @Override
    public List<JobExperienceDto> getAll() {
        return jobExperienceRepository.findAll()
                .stream()
                .map(jobExperienceMapper::jobExperienceToJobExperienceDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void delete(Integer id) {

        ValidationUtil.validateId(id);
        jobExperienceRepository.findById(id).orElseThrow();

        jobExperienceRepository.deleteById(id);

    }

    @Transactional
    @Override
    public JobExperienceDto create(JobExperienceInDto jobExperienceInDto) {

        JobExperience jobExperience = jobExperienceMapper
                .JobExperienceInDtoToJobExperience(jobExperienceInDto);

        jobExperience.setPerson(personService.findByEmail(PersonUtil.EMAIL));

        if(jobExperienceInDto.getBusinessId() != null){
            jobExperience.setBusiness(businessService.findById(jobExperienceInDto.getBusinessId()));
        }

        jobExperience.setJobExperienceType(jobExperienceTypeService
                .findById(jobExperienceInDto.getJobExperienceTypeId()));

        jobExperience.setSeniorityType(seniorityTypeService
                .findById(jobExperienceInDto.getSeniorityTypeId()));

        jobExperienceRepository.save(jobExperience);

        return jobExperienceMapper.jobExperienceToJobExperienceDto(jobExperience);

    }

}
