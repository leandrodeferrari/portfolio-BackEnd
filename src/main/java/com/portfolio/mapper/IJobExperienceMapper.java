package com.portfolio.mapper;

import com.portfolio.dto.request.JobExperienceInDto;
import com.portfolio.dto.response.JobExperienceDto;
import com.portfolio.model.entity.JobExperience;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {IBusinessMapper.class})
public interface IJobExperienceMapper {

    @Mappings({
            @Mapping(target = "startDate", dateFormat = "MM/yyyy"),
            @Mapping(target = "endDate", dateFormat = "MM/yyyy"),
            @Mapping(target = "seniorityName", source = "jobExperience.seniorityType.name"),
            @Mapping(target = "jobExperienceTypeName", source = "jobExperience.jobExperienceType.name"),
            @Mapping(target = "businessDto", source = "business")
    })
    JobExperienceDto jobExperienceToJobExperienceDto(JobExperience jobExperience);

    @Mappings({
            @Mapping(target = "business", ignore = true),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "jobExperienceType", ignore = true),
            @Mapping(target = "person", ignore = true),
            @Mapping(target = "seniorityType", ignore = true)
    })
    JobExperience JobExperienceInDtoToJobExperience(JobExperienceInDto jobExperienceInDto);

}
