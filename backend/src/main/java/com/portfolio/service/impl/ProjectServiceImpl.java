package com.portfolio.service.impl;

import com.portfolio.dto.ProjectDto;
import com.portfolio.mapper.IProjectMapper;
import com.portfolio.repository.IProjectRepository;
import com.portfolio.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements IProjectService {

    private final IProjectMapper projectMapper;
    private final IProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(IProjectMapper projectMapper, IProjectRepository projectRepository){
        this.projectMapper = projectMapper;
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectDto> getAll() {
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::projectToProjectDto)
                .collect(Collectors.toList());
    }

}
