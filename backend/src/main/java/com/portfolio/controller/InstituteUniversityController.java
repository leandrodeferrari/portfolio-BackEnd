package com.portfolio.controller;

import com.portfolio.dto.InstituteUniversityDto;
import com.portfolio.service.IInstituteUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/institutes-universities")
public class InstituteUniversityController {

    private final IInstituteUniversityService instituteUniversityService;

    @Autowired
    public InstituteUniversityController(IInstituteUniversityService instituteUniversityService){
        this.instituteUniversityService = instituteUniversityService;
    }

    @GetMapping
    public ResponseEntity<List<InstituteUniversityDto>> getAll(){
        return ResponseEntity.ok().body(instituteUniversityService.getAll());
    }

}
