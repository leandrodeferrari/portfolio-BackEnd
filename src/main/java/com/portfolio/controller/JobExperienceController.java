package com.portfolio.controller;

import com.portfolio.dto.request.JobExperienceInDto;
import com.portfolio.dto.response.JobExperienceDto;
import com.portfolio.service.IJobExperienceService;
import com.portfolio.service.IJobExperienceTypeService;
import com.portfolio.service.ISeniorityTypeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@Tag(name = "Job Experience", description = "JobExperience Controller")
@RestController
@RequestMapping("job-experiences")
public class JobExperienceController {

    private final IJobExperienceService jobExperienceService;
    private final IJobExperienceTypeService jobExperienceTypeService;
    private final ISeniorityTypeService seniorityTypeService;

    @Autowired
    public JobExperienceController(IJobExperienceService jobExperienceService,
                                   IJobExperienceTypeService jobExperienceTypeService,
                                   ISeniorityTypeService seniorityTypeService){
        this.jobExperienceService = jobExperienceService;
        this.jobExperienceTypeService = jobExperienceTypeService;
        this.seniorityTypeService = seniorityTypeService;
    }

    @Operation(description = "Get All Job Experiences. Any User. Parameters: none")
    @GetMapping
    public ResponseEntity<List<JobExperienceDto>> getAll(){
        return ResponseEntity.ok().body(jobExperienceService.getAll());
    }

    @Operation(description = "Get All Job Experience Types. Any User. Parameters: none")
    @GetMapping("/types")
    public ResponseEntity<List<String>> getAllTypes(){
        return ResponseEntity.ok().body(jobExperienceTypeService.getAllTypes());
    }

    @Operation(description = "Get All Seniority Types. Any User. Parameters: none")
    @GetMapping("/senioritys/types")
    public ResponseEntity<List<String>> getAllSeniorityTypes(){
        return ResponseEntity.ok().body(seniorityTypeService.getAllSeniorityTypes());
    }

    @Operation(description = "Delete a Job Experience. Role: Admin. Parameters: Path Variable id")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        jobExperienceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Create a Job Experience. User Authenticated. Parameters: Schema JobExperienceInDto.")
    @PostMapping
    public ResponseEntity<JobExperienceDto> create(@Valid @RequestBody JobExperienceInDto jobExperienceInDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(jobExperienceService.create(jobExperienceInDto));
    }

    @Operation(description = "Update a Job Experience. User Authenticated. Parameters: Schema JobExperienceInDto, Path Variable id.")
    @PutMapping("/{id}")
    public ResponseEntity<JobExperienceDto> update(@Valid @RequestBody JobExperienceInDto jobExperienceInDto,
                                                   @PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(jobExperienceService.update(jobExperienceInDto, id));
    }

}
