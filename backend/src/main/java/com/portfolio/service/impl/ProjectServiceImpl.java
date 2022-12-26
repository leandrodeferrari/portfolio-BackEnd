package com.portfolio.service.impl;

import com.portfolio.dto.request.ProjectInDto;
import com.portfolio.dto.response.ProjectDto;
import com.portfolio.exception.BadRequestException;
import com.portfolio.mapper.IProjectMapper;
import com.portfolio.model.entity.Project;
import com.portfolio.repository.IProjectRepository;
import com.portfolio.service.IBusinessService;
import com.portfolio.service.IPersonService;
import com.portfolio.service.IProjectService;
import com.portfolio.service.IProjectTypeService;
import com.portfolio.util.PersonUtil;
import com.portfolio.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements IProjectService {

    private final IBusinessService businessService;
    private final IPersonService personService;
    private final IProjectMapper projectMapper;
    private final IProjectRepository projectRepository;
    private final IProjectTypeService projectTypeService;

    @Autowired
    public ProjectServiceImpl(IBusinessService businessService,
                              IPersonService personService,
                              IProjectMapper projectMapper,
                              IProjectRepository projectRepository,
                              IProjectTypeService projectTypeService){
        this.businessService = businessService;
        this.personService = personService;
        this.projectMapper = projectMapper;
        this.projectRepository = projectRepository;
        this.projectTypeService = projectTypeService;
    }

    @Override
    public List<ProjectDto> getAll() {
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::projectToProjectDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void delete(Integer id) {

        ValidationUtil.validateId(id);
        projectRepository.findById(id).orElseThrow();

        projectRepository.deleteById(id);

    }

    @Transactional
    @Override
    public ProjectDto create(ProjectInDto projectInDto) {

        Project project = projectMapper.projectInDtoToProject(projectInDto);

        if(projectInDto.getBusinessId() != null){
            project.setBusiness(businessService.findById(projectInDto.getBusinessId()));
        }

        project.setPerson(personService.findByEmail(PersonUtil.EMAIL));

        project.setProjectType(projectTypeService.findById(projectInDto.getProjectTypeId()));

        projectRepository.save(project);

        return projectMapper.projectToProjectDto(project);

    }

    @Transactional
    @Override
    public ProjectDto update(ProjectInDto projectInDto, Integer id) {

        ValidationUtil.validateId(id);

        if(projectRepository.existsById(id)){

            Project project = projectMapper.projectInDtoToProject(projectInDto);
            project.setId(id);

            if(projectInDto.getBusinessId() != null){
                project.setBusiness(businessService.findById(projectInDto.getBusinessId()));
            }

            project.setPerson(personService.findByEmail(PersonUtil.EMAIL));

            project.setProjectType(projectTypeService.findById(projectInDto.getProjectTypeId()));

            projectRepository.save(project);

            return projectMapper.projectToProjectDto(project);

        } else {

            throw new BadRequestException("The ID not exists");

        }

    }

}
