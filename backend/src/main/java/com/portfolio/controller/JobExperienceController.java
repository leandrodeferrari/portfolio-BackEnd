package com.portfolio.controller;

import com.portfolio.dto.JobExperienceDto;
import com.portfolio.service.IJobExperienceService;
import com.portfolio.service.IJobExperienceTypeService;
import com.portfolio.service.ISeniorityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
