package com.portfolio.mapper;

import com.portfolio.dto.JobExperienceDto;
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
            @Mapping(target = "startDate", dateFormat = "dd.MM.yyyy"),
            @Mapping(target = "endDate", dateFormat = "dd.MM.yyyy"),
            @Mapping(target = "seniorityName", source = "jobExperience.seniorityType.name"),
            @Mapping(target = "jobExperienceName", source = "jobExperience.jobExperienceType.name"),
            @Mapping(target = "businessDto", source = "business")
    })
    JobExperienceDto jobExperienceToJobExperienceDto(JobExperience jobExperience);

}
