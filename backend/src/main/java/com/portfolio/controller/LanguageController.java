package com.portfolio.controller;

import com.portfolio.dto.LanguageDto;
import com.portfolio.service.ILanguageLevelService;
import com.portfolio.service.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    private final ILanguageLevelService languageLevelService;
    private final ILanguageService languageService;

    @Autowired
    public LanguageController(ILanguageLevelService languageLevelService,
                              ILanguageService languageService){
        this.languageLevelService = languageLevelService;
        this.languageService = languageService;
    }

    @GetMapping
    public ResponseEntity<List<LanguageDto>> getAll(){
        return ResponseEntity.ok().body(languageService.getAll());
    }

    @GetMapping("/levels")
    public ResponseEntity<List<String>> getAllLevels(){
        return ResponseEntity.ok().body(languageLevelService.getAllLevels());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        languageService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
