package com.portfolio.mapper;

import com.portfolio.dto.ProjectDto;
import com.portfolio.model.entity.Project;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {IBusinessMapper.class})
public interface IProjectMapper {

    @Mappings({
            @Mapping(target = "startDate", dateFormat = "dd.MM.yyyy"),
            @Mapping(target = "endDate", dateFormat = "dd.MM.yyyy"),
            @Mapping(target = "projectTypeName", source = "project.projectType.name"),
            @Mapping(target = "businessDto", source = "business")
    })
    ProjectDto projectToProjectDto(Project project);

}