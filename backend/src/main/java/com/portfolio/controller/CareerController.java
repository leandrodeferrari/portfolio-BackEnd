package com.portfolio.controller;

import com.portfolio.dto.CareerDto;
import com.portfolio.service.ICareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/careers")
public class CareerController {

    private final ICareerService careerService;

    @Autowired
    public CareerController(ICareerService careerService){
        this.careerService = careerService;
    }

    @GetMapping
    public ResponseEntity<List<CareerDto>> getAll(){
        return ResponseEntity.ok().body(careerService.getAll());
    }


}
