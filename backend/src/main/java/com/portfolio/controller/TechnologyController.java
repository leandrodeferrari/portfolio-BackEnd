package com.portfolio.controller;

import com.portfolio.dto.request.TechnologyInDto;
import com.portfolio.dto.response.TechnologyDto;
import com.portfolio.service.ITechnologyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@Tag(name = "Technology", description = "Technology Controller")
@RestController
@RequestMapping("/technologies")
public class TechnologyController {

    private final ITechnologyService technologyService;

    @Autowired
    public TechnologyController(ITechnologyService technologyService){
        this.technologyService = technologyService;
    }

    @Operation(description = "Get All Technologies. Any User. Parameters: none")
    @GetMapping
    public ResponseEntity<List<TechnologyDto>> getAll(){
        return ResponseEntity.ok().body(technologyService.getAll());
    }

    @Operation(description = "Delete a Technology. Role: Admin. Parameters: Path Variable id")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        technologyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Create a Technology. User Authenticated. Parameters: Schema TechnologyInDto.")
    @PostMapping
    public ResponseEntity<TechnologyDto> create(@Valid @RequestBody TechnologyInDto technologyInDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(technologyService.create(technologyInDto));
    }

    @Operation(description = "Update a Technology. User Authenticated. Parameters: Schema TechnologyInDto, Path Variable id.")
    @PutMapping("/{id}")
    public ResponseEntity<TechnologyDto> update(@Valid @RequestBody TechnologyInDto technologyInDto,
                                                @PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.CREATED).body(technologyService.update(technologyInDto, id));
    }

}
