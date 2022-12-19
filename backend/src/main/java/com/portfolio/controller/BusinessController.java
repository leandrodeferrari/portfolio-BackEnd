package com.portfolio.controller;

import com.portfolio.dto.BusinessDto;
import com.portfolio.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/businesses")
public class BusinessController {

    private final IBusinessService businessService;

    @Autowired
    public BusinessController(IBusinessService businessService){
        this.businessService = businessService;
    }

    @GetMapping
    public ResponseEntity<List<BusinessDto>> getAll(){
        return ResponseEntity.ok().body(businessService.getAll());
    }

}
