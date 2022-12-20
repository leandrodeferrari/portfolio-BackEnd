package com.portfolio.controller;

import com.portfolio.dto.ProjectDto;
import com.portfolio.service.IProjectService;
import com.portfolio.service.IProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
