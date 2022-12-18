package com.portfolio.controller;

import com.portfolio.dto.TechnologyDto;
import com.portfolio.service.ITechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/technologies")
public class TechnologyController {

    private final ITechnologyService technologyService;

    @Autowired
    public TechnologyController(ITechnologyService technologyService){
        this.technologyService = technologyService;
    }

    @GetMapping
    public ResponseEntity<List<TechnologyDto>> getAll(){
        return ResponseEntity.ok().body(technologyService.getAll());
    }

}
