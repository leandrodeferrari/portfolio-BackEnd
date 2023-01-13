package com.portfolio.controller;

import com.portfolio.dto.request.CourseInDto;
import com.portfolio.dto.response.CourseDto;
import com.portfolio.service.ICourseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "www.leandrodeferrari.com.ar"})
@Tag(name = "Course", description = "Course Controller")
@RestController
@RequestMapping("/courses")
public class CourseController {

    private final ICourseService courseService;

    @Autowired
    public CourseController(ICourseService courseService){
        this.courseService = courseService;
    }

    @Operation(description = "Get All Courses. Any User. Parameters: none")
    @GetMapping
    public ResponseEntity<List<CourseDto>> getAll(){
        return ResponseEntity.ok().body(courseService.getAll());
    }

    @Operation(description = "Delete a Course. Role: Admin. Parameters: Path Variable id")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Create a Course. User Authenticated. Parameters: Schema CourseInDto.")
    @PostMapping
    public ResponseEntity<CourseDto> create(@Valid @RequestBody CourseInDto courseInDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.create(courseInDto));
    }

    @Operation(description = "Update a Course. User Authenticated. Parameters: Schema CourseInDto, Path Variable id.")
    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> update(@Valid @RequestBody CourseInDto courseInDto,
                                            @PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.update(courseInDto, id));
    }

}
