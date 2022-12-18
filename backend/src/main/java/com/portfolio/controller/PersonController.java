package com.portfolio.controller;

import com.portfolio.dto.PersonDto;
import com.portfolio.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final IPersonService personService;

    @Autowired
    public PersonController(IPersonService personService){
        this.personService = personService;
    }

    @GetMapping("/person")
    public ResponseEntity<PersonDto> getPerson(){
        return ResponseEntity.ok().body(personService.getPerson());
    }

}
