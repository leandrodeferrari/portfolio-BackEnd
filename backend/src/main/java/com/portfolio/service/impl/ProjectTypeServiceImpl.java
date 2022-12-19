package com.portfolio.service.impl;

import com.portfolio.model.entity.ProjectType;
import com.portfolio.repository.IProjectTypeRepository;
import com.portfolio.service.IProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTypeServiceImpl implements IProjectTypeService {

    private final IProjectTypeRepository projectTypeRepository;

    @Autowired
    public ProjectTypeServiceImpl(IProjectTypeRepository projectTypeRepository){
        this.projectTypeRepository = projectTypeRepository;
    }

    @Override
    public List<String> getAllTypes() {
        return projectTypeRepository.findAll()
                .stream()
                .map(ProjectType::getName)
                .toList();
    }

}
