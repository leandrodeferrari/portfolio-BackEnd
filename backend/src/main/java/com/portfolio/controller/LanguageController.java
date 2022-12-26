package com.portfolio.controller;

import com.portfolio.dto.request.LanguageInDto;
import com.portfolio.dto.response.LanguageDto;
import com.portfolio.service.ILanguageLevelService;
import com.portfolio.service.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity<LanguageDto> create(@Valid @RequestBody LanguageInDto languageInDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(languageService.create(languageInDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LanguageDto> update(@Valid @RequestBody LanguageInDto languageInDto,
                                              @PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.CREATED).body(languageService.update(languageInDto, id));
    }

}
