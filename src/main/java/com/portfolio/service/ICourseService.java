package com.portfolio.service;

import com.portfolio.dto.request.CourseInDto;
import com.portfolio.dto.response.CourseDto;

import java.util.List;

public interface ICourseService {

    List<CourseDto> getAll();
    void delete(Integer id);
    CourseDto create(CourseInDto courseInDto);
    CourseDto update(CourseInDto courseInDto, Integer id);

}
