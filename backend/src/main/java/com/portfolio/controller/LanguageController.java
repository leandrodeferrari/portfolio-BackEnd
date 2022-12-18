package com.portfolio.controller;

import com.portfolio.dto.LanguageDto;
import com.portfolio.service.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    private final ILanguageService languageService;

    @Autowired
    public LanguageController(ILanguageService languageService){
        this.languageService = languageService;
    }

    @GetMapping
    public ResponseEntity<List<LanguageDto>> getAll(){
        return ResponseEntity.ok().body(languageService.getAll());
    }

}
