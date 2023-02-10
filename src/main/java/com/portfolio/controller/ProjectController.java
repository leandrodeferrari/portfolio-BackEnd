package com.portfolio.controller;

import com.portfolio.dto.request.ProjectInDto;
import com.portfolio.dto.response.ProjectDto;
import com.portfolio.service.IProjectService;
import com.portfolio.service.IProjectTypeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@CrossOrigin(origins = "https://leandro-deferrari.web.app")
@Tag(name = "Project", description = "Project Controller")
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

    @Operation(description = "Get All Projects. Any User. Parameters: none")
    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAll(){
        return ResponseEntity.ok().body(projectService.getAll());
    }

    @Operation(description = "Get All Project Types. Any User. Parameters: none")
    @GetMapping("/types")
    public ResponseEntity<List<String>> getAllTypes(){
        return ResponseEntity.ok().body(projectTypeService.getAllTypes());
    }

    @Operation(description = "Delete a Project. Role: Admin. Parameters: Path Variable id")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Create a Project. User Authenticated. Parameters: Schema ProjectInDto.")
    @PostMapping
    public ResponseEntity<ProjectDto> create(@Valid @RequestBody ProjectInDto projectInDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.create(projectInDto));
    }

    @Operation(description = "Update a Project. User Authenticated. Parameters: Schema ProjectInDto, Path Variable id.")
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> update(@Valid @RequestBody ProjectInDto projectInDto,
                                             @PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.update(projectInDto, id));
    }

}
