package com.portfolio.controller;

import com.portfolio.dto.request.LanguageInDto;
import com.portfolio.dto.response.LanguageDto;
import com.portfolio.service.ILanguageLevelService;
import com.portfolio.service.ILanguageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@CrossOrigin(origins = "https://leandro-deferrari.web.app")
@Tag(name = "Language", description = "Language Controller")
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

    @Operation(description = "Get All Languages. Any User. Parameters: none")
    @GetMapping
    public ResponseEntity<List<LanguageDto>> getAll(){
        return ResponseEntity.ok().body(languageService.getAll());
    }

    @Operation(description = "Get All Language Levels. Any User. Parameters: none")
    @GetMapping("/levels")
    public ResponseEntity<List<String>> getAllLevels(){
        return ResponseEntity.ok().body(languageLevelService.getAllLevels());
    }

    @Operation(description = "Delete a Language. Role: Admin. Parameters: Path Variable id")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        languageService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Create a Language. User Authenticated. Parameters: Schema LanguageInDto.")
    @PostMapping
    public ResponseEntity<LanguageDto> create(@Valid @RequestBody LanguageInDto languageInDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(languageService.create(languageInDto));
    }

    @Operation(description = "Update a Language. User Authenticated. Parameters: Schema LanguageInDto, Path Variable id.")
    @PutMapping("/{id}")
    public ResponseEntity<LanguageDto> update(@Valid @RequestBody LanguageInDto languageInDto,
                                              @PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.CREATED).body(languageService.update(languageInDto, id));
    }

}
