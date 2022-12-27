package com.portfolio.controller;

import com.portfolio.dto.request.CareerInDto;
import com.portfolio.dto.response.CareerDto;
import com.portfolio.service.ICareerService;
import com.portfolio.service.ICareerTypeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@Tag(name = "Career", description = "Career Controller")
@RestController
@RequestMapping("/careers")
public class CareerController {

    private final ICareerService careerService;
    private final ICareerTypeService careerTypeService;

    @Autowired
    public CareerController(ICareerService careerService, ICareerTypeService careerTypeService){
        this.careerService = careerService;
        this.careerTypeService = careerTypeService;
    }

    @Operation(description = "Get All Careers. Any User. Parameters: none")
    @GetMapping
    public ResponseEntity<List<CareerDto>> getAll(){
        return ResponseEntity.ok().body(careerService.getAll());
    }

    @Operation(description = "Get All Career Types. Any User. Parameters: none")
    @GetMapping("/types")
    public ResponseEntity<List<String>> getAllTypes(){
        return ResponseEntity.ok().body(careerTypeService.getAllTypes());
    }

    @Operation(description = "Delete a Career. Role: Admin. Parameters: Path Variable id")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        careerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Create a Career. User Authenticated. Parameters: Schema CareerInDto.")
    @PostMapping
    public ResponseEntity<CareerDto> create(@Valid @RequestBody CareerInDto careerInDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(careerService.create(careerInDto));
    }

    @Operation(description = "Update a Career. User Authenticated. Parameters: Schema CareerInDto, Path Variable id.")
    @PutMapping("/{id}")
    public ResponseEntity<CareerDto> update(@Valid @RequestBody CareerInDto careerInDto,
                                            @PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.CREATED).body(careerService.update(careerInDto, id));
    }

}
