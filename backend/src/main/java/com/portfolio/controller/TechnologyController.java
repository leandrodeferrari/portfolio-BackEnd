package com.portfolio.controller;

import com.portfolio.dto.request.TechnologyInDto;
import com.portfolio.dto.response.TechnologyDto;
import com.portfolio.service.ITechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        technologyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<TechnologyDto> create(@Valid @RequestBody TechnologyInDto technologyInDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(technologyService.create(technologyInDto));
    }

}
