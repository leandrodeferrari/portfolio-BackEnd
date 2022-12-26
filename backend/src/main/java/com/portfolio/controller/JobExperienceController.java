package com.portfolio.controller;

import com.portfolio.dto.request.JobExperienceInDto;
import com.portfolio.dto.response.JobExperienceDto;
import com.portfolio.service.IJobExperienceService;
import com.portfolio.service.IJobExperienceTypeService;
import com.portfolio.service.ISeniorityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<JobExperienceDto>> getAll(){
        return ResponseEntity.ok().body(jobExperienceService.getAll());
    }

    @GetMapping("/types")
    public ResponseEntity<List<String>> getAllTypes(){
        return ResponseEntity.ok().body(jobExperienceTypeService.getAllTypes());
    }

    @GetMapping("/senioritys/types")
    public ResponseEntity<List<String>> getAllSeniorityTypes(){
        return ResponseEntity.ok().body(seniorityTypeService.getAllSeniorityTypes());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        jobExperienceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<JobExperienceDto> create(@Valid @RequestBody JobExperienceInDto jobExperienceInDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(jobExperienceService.create(jobExperienceInDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobExperienceDto> update(@Valid @RequestBody JobExperienceInDto jobExperienceInDto,
                                                   @PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(jobExperienceService.update(jobExperienceInDto, id));
    }

}
