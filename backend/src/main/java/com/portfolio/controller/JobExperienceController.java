package com.portfolio.controller;

import com.portfolio.dto.JobExperienceDto;
import com.portfolio.service.IJobExperienceService;
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

    @Autowired
    public JobExperienceController(IJobExperienceService jobExperienceService){
        this.jobExperienceService = jobExperienceService;
    }

    @GetMapping
    public ResponseEntity<List<JobExperienceDto>> getAll(){
        return ResponseEntity.ok().body(jobExperienceService.getAll());
    }

}
