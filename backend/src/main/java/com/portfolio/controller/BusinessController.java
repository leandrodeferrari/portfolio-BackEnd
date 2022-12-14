package com.portfolio.controller;

import com.portfolio.dto.request.BusinessInDto;
import com.portfolio.dto.response.BusinessDto;
import com.portfolio.service.IBusinessService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@Tag(name = "Business", description = "Business Controller")
@RestController
@RequestMapping("/businesses")
public class BusinessController {

    private final IBusinessService businessService;

    @Autowired
    public BusinessController(IBusinessService businessService){
        this.businessService = businessService;
    }

    @Operation(description = "Get All Businesses. Any User. Parameters: none")
    @GetMapping
    public ResponseEntity<List<BusinessDto>> getAll(){
        return ResponseEntity.ok().body(businessService.getAll());
    }

    @Operation(description = "Create a Business. User Authenticated. Parameters: Schema BusinessInDto.")
    @PostMapping
    public ResponseEntity<BusinessDto> create(@Valid @RequestBody BusinessInDto businessInDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(businessService.create(businessInDto));
    }

}
