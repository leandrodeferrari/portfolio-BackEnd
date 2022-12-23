package com.portfolio.service;

import com.portfolio.dto.response.CourseDto;

import java.util.List;

public interface ICourseService {

    List<CourseDto> getAll();

    void delete(Integer id);

}
