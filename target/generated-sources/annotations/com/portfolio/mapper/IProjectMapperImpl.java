package com.portfolio.mapper;

import com.portfolio.dto.request.ProjectInDto;
import com.portfolio.dto.response.ProjectDto;
import com.portfolio.model.entity.Project;
import com.portfolio.model.entity.ProjectType;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-06T12:48:22-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class IProjectMapperImpl implements IProjectMapper {

    private final IBusinessMapper iBusinessMapper;
    private final DateTimeFormatter dateTimeFormatter_MM_yyyy_11869881679 = DateTimeFormatter.ofPattern( "MM/yyyy" );

    @Autowired
    public IProjectMapperImpl(IBusinessMapper iBusinessMapper) {

        this.iBusinessMapper = iBusinessMapper;
    }

    @Override
    public ProjectDto projectToProjectDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();

        if ( project.getStartDate() != null ) {
            projectDto.setStartDate( dateTimeFormatter_MM_yyyy_11869881679.format( project.getStartDate() ) );
        }
        if ( project.getEndDate() != null ) {
            projectDto.setEndDate( dateTimeFormatter_MM_yyyy_11869881679.format( project.getEndDate() ) );
        }
        projectDto.setProjectTypeName( projectProjectTypeName( project ) );
        projectDto.setBusinessDto( iBusinessMapper.businessToBusinessDto( project.getBusiness() ) );
        projectDto.setId( project.getId() );
        projectDto.setName( project.getName() );
        projectDto.setDescription( project.getDescription() );
        projectDto.setImageUrl( project.getImageUrl() );
        projectDto.setEvidenceUrl( project.getEvidenceUrl() );

        return projectDto;
    }

    @Override
    public Project projectInDtoToProject(ProjectInDto projectInDto) {
        if ( projectInDto == null ) {
            return null;
        }

        Project project = new Project();

        project.setName( projectInDto.getName() );
        project.setStartDate( projectInDto.getStartDate() );
        project.setEndDate( projectInDto.getEndDate() );
        project.setDescription( projectInDto.getDescription() );
        project.setImageUrl( projectInDto.getImageUrl() );
        project.setEvidenceUrl( projectInDto.getEvidenceUrl() );

        return project;
    }

    private String projectProjectTypeName(Project project) {
        if ( project == null ) {
            return null;
        }
        ProjectType projectType = project.getProjectType();
        if ( projectType == null ) {
            return null;
        }
        String name = projectType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
