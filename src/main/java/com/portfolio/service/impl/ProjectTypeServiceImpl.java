package com.portfolio.service.impl;

import com.portfolio.model.entity.ProjectType;
import com.portfolio.repository.IProjectTypeRepository;
import com.portfolio.service.IProjectTypeService;
import com.portfolio.util.ValidationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectTypeServiceImpl implements IProjectTypeService {

    private final IProjectTypeRepository projectTypeRepository;

    @Autowired
    public ProjectTypeServiceImpl(IProjectTypeRepository projectTypeRepository){
        this.projectTypeRepository = projectTypeRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> getAllTypes() {
        return projectTypeRepository.findAll()
                .stream()
                .map(ProjectType::getName)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public ProjectType findById(Integer id) {

        ValidationUtil.validateId(id);

        return projectTypeRepository.findById(id).orElseThrow();

    }

}
