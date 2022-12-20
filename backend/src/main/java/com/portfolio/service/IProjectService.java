package com.portfolio.service;

import com.portfolio.dto.ProjectDto;

import java.util.List;

public interface IProjectService {

    List<ProjectDto> getAll();

    void delete(Integer id);

}
