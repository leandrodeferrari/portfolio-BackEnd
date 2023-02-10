package com.portfolio.controller;

import com.portfolio.dto.request.EmailDto;
import com.portfolio.dto.response.AboutDto;
import com.portfolio.dto.response.BannerDto;
import com.portfolio.dto.response.ContactDto;
import com.portfolio.dto.response.PersonDto;
import com.portfolio.exception.EmailException;
import com.portfolio.service.IEmailService;
import com.portfolio.service.IPersonService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "https://leandro-deferrari.web.app")
@Tag(name = "Person", description = "Person Controller")
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final IEmailService emailService;
    private final IPersonService personService;

    @Autowired
    public PersonController(IEmailService emailService, IPersonService personService){
        this.emailService = emailService;
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

    @PostMapping("/contact")
    public ResponseEntity<Map<String, String>> sendEmail(@RequestBody EmailDto emailDto) throws EmailException {
        return ResponseEntity.ok().body(emailService.sendEMail(emailDto));
    }

}
