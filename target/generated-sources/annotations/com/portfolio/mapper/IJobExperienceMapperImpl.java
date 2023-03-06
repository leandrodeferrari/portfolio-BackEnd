package com.portfolio.mapper;

import com.portfolio.dto.request.JobExperienceInDto;
import com.portfolio.dto.response.JobExperienceDto;
import com.portfolio.model.entity.JobExperience;
import com.portfolio.model.entity.JobExperienceType;
import com.portfolio.model.entity.SeniorityType;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-06T18:41:42-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class IJobExperienceMapperImpl implements IJobExperienceMapper {

    private final IBusinessMapper iBusinessMapper;
    private final DateTimeFormatter dateTimeFormatter_MM_yyyy_11869881679 = DateTimeFormatter.ofPattern( "MM/yyyy" );

    @Autowired
    public IJobExperienceMapperImpl(IBusinessMapper iBusinessMapper) {

        this.iBusinessMapper = iBusinessMapper;
    }

    @Override
    public JobExperienceDto jobExperienceToJobExperienceDto(JobExperience jobExperience) {
        if ( jobExperience == null ) {
            return null;
        }

        JobExperienceDto jobExperienceDto = new JobExperienceDto();

        if ( jobExperience.getStartDate() != null ) {
            jobExperienceDto.setStartDate( dateTimeFormatter_MM_yyyy_11869881679.format( jobExperience.getStartDate() ) );
        }
        if ( jobExperience.getEndDate() != null ) {
            jobExperienceDto.setEndDate( dateTimeFormatter_MM_yyyy_11869881679.format( jobExperience.getEndDate() ) );
        }
        jobExperienceDto.setSeniorityName( jobExperienceSeniorityTypeName( jobExperience ) );
        jobExperienceDto.setJobExperienceTypeName( jobExperienceJobExperienceTypeName( jobExperience ) );
        jobExperienceDto.setBusinessDto( iBusinessMapper.businessToBusinessDto( jobExperience.getBusiness() ) );
        jobExperienceDto.setId( jobExperience.getId() );
        jobExperienceDto.setName( jobExperience.getName() );
        jobExperienceDto.setCurrentJob( jobExperience.isCurrentJob() );
        jobExperienceDto.setDescription( jobExperience.getDescription() );

        return jobExperienceDto;
    }

    @Override
    public JobExperience JobExperienceInDtoToJobExperience(JobExperienceInDto jobExperienceInDto) {
        if ( jobExperienceInDto == null ) {
            return null;
        }

        JobExperience jobExperience = new JobExperience();

        jobExperience.setName( jobExperienceInDto.getName() );
        jobExperience.setStartDate( jobExperienceInDto.getStartDate() );
        jobExperience.setEndDate( jobExperienceInDto.getEndDate() );
        jobExperience.setCurrentJob( jobExperienceInDto.isCurrentJob() );
        jobExperience.setDescription( jobExperienceInDto.getDescription() );

        return jobExperience;
    }

    private String jobExperienceSeniorityTypeName(JobExperience jobExperience) {
        if ( jobExperience == null ) {
            return null;
        }
        SeniorityType seniorityType = jobExperience.getSeniorityType();
        if ( seniorityType == null ) {
            return null;
        }
        String name = seniorityType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String jobExperienceJobExperienceTypeName(JobExperience jobExperience) {
        if ( jobExperience == null ) {
            return null;
        }
        JobExperienceType jobExperienceType = jobExperience.getJobExperienceType();
        if ( jobExperienceType == null ) {
            return null;
        }
        String name = jobExperienceType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
