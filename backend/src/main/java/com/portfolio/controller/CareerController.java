package com.portfolio.controller;

import com.portfolio.dto.CareerDto;
import com.portfolio.service.ICareerService;
import com.portfolio.service.ICareerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<CareerDto>> getAll(){
        return ResponseEntity.ok().body(careerService.getAll());
    }

    @GetMapping("/types")
    public ResponseEntity<List<String>> getAllTypes(){
        return ResponseEntity.ok().body(careerTypeService.getAllTypes());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        careerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
