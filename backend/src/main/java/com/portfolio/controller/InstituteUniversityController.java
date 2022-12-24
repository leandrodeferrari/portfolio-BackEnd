package com.portfolio.controller;

import com.portfolio.dto.request.InstituteUniversityInDto;
import com.portfolio.dto.response.InstituteUniversityDto;
import com.portfolio.service.IInstituteUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity<InstituteUniversityDto> create(@Valid @RequestBody InstituteUniversityInDto instituteUniversityInDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(instituteUniversityService.create(instituteUniversityInDto));
    }

}
