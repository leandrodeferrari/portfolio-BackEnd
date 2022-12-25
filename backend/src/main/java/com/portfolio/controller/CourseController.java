package com.portfolio.controller;

import com.portfolio.dto.request.CourseInDto;
import com.portfolio.dto.response.CourseDto;
import com.portfolio.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final ICourseService courseService;

    @Autowired
    public CourseController(ICourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAll(){
        return ResponseEntity.ok().body(courseService.getAll());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<CourseDto> create(@Valid @RequestBody CourseInDto courseInDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.create(courseInDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> update(@Valid @RequestBody CourseInDto courseInDto,
                                            @PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.update(courseInDto, id));
    }

}
