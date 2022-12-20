package com.portfolio.service.impl;

import com.portfolio.dto.CourseDto;
import com.portfolio.mapper.ICourseMapper;
import com.portfolio.repository.ICourseRepository;
import com.portfolio.service.ICourseService;
import com.portfolio.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements ICourseService {

    private final ICourseMapper courseMapper;
    private final ICourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(ICourseMapper courseMapper, ICourseRepository courseRepository){
        this.courseMapper = courseMapper;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDto> getAll() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::courseToCourseDto).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void delete(Integer id) {

        ValidationUtil.validateId(id);
        courseRepository.findById(id).orElseThrow();

        courseRepository.deleteById(id);

    }

}
