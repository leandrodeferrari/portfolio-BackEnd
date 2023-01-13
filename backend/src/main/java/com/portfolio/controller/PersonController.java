package com.portfolio.controller;

import com.portfolio.dto.response.AboutDto;
import com.portfolio.dto.response.BannerDto;
import com.portfolio.dto.response.ContactDto;
import com.portfolio.dto.response.PersonDto;
import com.portfolio.service.IPersonService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200", "www.leandrodeferrari.com.ar"})
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

    @Operation(description = "Get a Banner. Any User. Parameters: none")
    @GetMapping("/banner")
    public ResponseEntity<BannerDto> getBanner(){
        return ResponseEntity.ok().body(personService.getBanner());
    }

    @Operation(description = "Get Contact. Any User. Parameters: none")
    @GetMapping("/contact")
    public ResponseEntity<ContactDto> getContact(){
        return ResponseEntity.ok().body(personService.getContact());
    }

    @Operation(description = "Get About. Any User. Parameters: none")
    @GetMapping("/about")
    public ResponseEntity<AboutDto> getAbout(){
        return ResponseEntity.ok().body(personService.getAbout());
    }

}
