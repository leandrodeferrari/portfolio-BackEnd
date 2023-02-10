package com.portfolio.controller;

import com.portfolio.dto.request.InstituteUniversityInDto;
import com.portfolio.dto.response.InstituteUniversityDto;
import com.portfolio.service.IInstituteUniversityService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@CrossOrigin(origins = "https://leandro-deferrari.web.app")
@Tag(name = "Institute/University", description = "InstituteUniversity Controller")
@RestController
@RequestMapping("/institutes-universities")
public class InstituteUniversityController {

    private final IInstituteUniversityService instituteUniversityService;

    @Autowired
    public InstituteUniversityController(IInstituteUniversityService instituteUniversityService){
        this.instituteUniversityService = instituteUniversityService;
    }

    @Operation(description = "Get All Institutes/Universities. Any User. Parameters: none")
    @GetMapping
    public ResponseEntity<List<InstituteUniversityDto>> getAll(){
        return ResponseEntity.ok().body(instituteUniversityService.getAll());
    }

    @Operation(description = "Create a Institute/University. User Authenticated. Parameters: Schema InstituteUniversityInDto.")
    @PostMapping
    public ResponseEntity<InstituteUniversityDto> create(@Valid @RequestBody InstituteUniversityInDto instituteUniversityInDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(instituteUniversityService.create(instituteUniversityInDto));
    }

}
