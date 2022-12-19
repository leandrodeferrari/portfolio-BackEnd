package com.portfolio.controller;

import com.portfolio.dto.ProjectDto;
import com.portfolio.service.IProjectService;
import com.portfolio.service.IProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final IProjectService projectService;
    private final IProjectTypeService projectTypeService;

    @Autowired
    public ProjectController(IProjectService projectService,
                             IProjectTypeService projectTypeService){
        this.projectService = projectService;
        this.projectTypeService = projectTypeService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAll(){
        return ResponseEntity.ok().body(projectService.getAll());
    }

    @GetMapping("/types")
    public ResponseEntity<List<String>> getAllTypes(){
        return ResponseEntity.ok().body(projectTypeService.getAllTypes());
    }

}
