package com.portfolio.service;

import com.portfolio.model.entity.ProjectType;

import java.util.List;

public interface IProjectTypeService {

    List<String> getAllTypes();
    ProjectType findById(Integer id);

}
