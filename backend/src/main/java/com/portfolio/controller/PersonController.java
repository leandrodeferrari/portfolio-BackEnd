package com.portfolio.controller;

import com.portfolio.dto.response.PersonDto;
import com.portfolio.service.IPersonService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Person", description = "Person Controller")
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final IPersonService personService;

    @Autowired
    public PersonController(IPersonService personService){
        this.personService = personService;
    }

    @Operation(description = "Get a Person. Any User. Parameters: none")
    @GetMapping("/person")
    public ResponseEntity<PersonDto> getPerson(){
        return ResponseEntity.ok().body(personService.getPerson());
    }

}
