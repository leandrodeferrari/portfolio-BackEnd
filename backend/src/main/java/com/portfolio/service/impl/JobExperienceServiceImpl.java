package com.portfolio.service.impl;

import com.portfolio.dto.request.JobExperienceInDto;
import com.portfolio.dto.response.JobExperienceDto;
import com.portfolio.exception.BadRequestException;
import com.portfolio.mapper.IJobExperienceMapper;
import com.portfolio.model.entity.JobExperience;
import com.portfolio.repository.IJobExperienceRepository;
import com.portfolio.service.*;
import com.portfolio.util.PersonUtil;
import com.portfolio.util.ValidationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class JobExperienceServiceImpl implements IJobExperienceService {

    private final IBusinessService businessService;
    private final IJobExperienceMapper jobExperienceMapper;
    private final IJobExperienceRepository jobExperienceRepository;
    private final IJobExperienceTypeService jobExperienceTypeService;
    private final IPersonService personService;
    private final ISeniorityTypeService seniorityTypeService;
    private final MessageSource messageSource;

    @Autowired
    public JobExperienceServiceImpl(IBusinessService businessService,
                                    IJobExperienceMapper jobExperienceMapper,
                                    IJobExperienceRepository jobExperienceRepository,
                                    IJobExperienceTypeService jobExperienceTypeService,
                                    IPersonService personService,
                                    ISeniorityTypeService seniorityTypeService,
                                    MessageSource messageSource){
        this.businessService = businessService;
        this.jobExperienceMapper = jobExperienceMapper;
        this.jobExperienceRepository = jobExperienceRepository;
        this.jobExperienceTypeService = jobExperienceTypeService;
        this.personService = personService;
        this.seniorityTypeService = seniorityTypeService;
        this.messageSource = messageSource;
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

    @Transactional
    @Override
    public JobExperienceDto update(JobExperienceInDto jobExperienceInDto, Integer id) {

        ValidationUtil.validateId(id);

        if(jobExperienceRepository.existsById(id)){

            JobExperience jobExperience = jobExperienceMapper
                    .JobExperienceInDtoToJobExperience(jobExperienceInDto);
            jobExperience.setId(id);

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

        } else {

            throw new BadRequestException(messageSource.getMessage("validation.id.not.exists", null, Locale.getDefault()));

        }

    }

}
