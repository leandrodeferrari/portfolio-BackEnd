package com.portfolio.service.impl;

import com.portfolio.dto.request.CourseInDto;
import com.portfolio.dto.response.CourseDto;
import com.portfolio.exception.BadRequestException;
import com.portfolio.mapper.ICourseMapper;
import com.portfolio.model.entity.Course;
import com.portfolio.repository.ICourseRepository;
import com.portfolio.service.ICourseService;
import com.portfolio.service.IInstituteUniversityService;
import com.portfolio.service.IPersonService;
import com.portfolio.util.PersonUtil;
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
    private final IInstituteUniversityService instituteUniversityService;
    private final IPersonService personService;

    @Autowired
    public CourseServiceImpl(ICourseMapper courseMapper,
                             ICourseRepository courseRepository,
                             IInstituteUniversityService instituteUniversityService,
                             IPersonService personService){
        this.courseMapper = courseMapper;
        this.courseRepository = courseRepository;
        this.instituteUniversityService = instituteUniversityService;
        this.personService = personService;
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

    @Transactional
    @Override
    public CourseDto create(CourseInDto courseInDto) {

        Course course = courseMapper.courseInDtoToCourse(courseInDto);

        course.setPerson(personService.findByEmail(PersonUtil.EMAIL));

        course.setInstituteUniversity(instituteUniversityService
                .findById(courseInDto.getInstituteUniversityId()));

        courseRepository.save(course);

        return courseMapper.courseToCourseDto(course);

    }

    @Transactional
    @Override
    public CourseDto update(CourseInDto courseInDto, Integer id) {

        ValidationUtil.validateId(id);

        if(courseRepository.existsById(id)){

            Course course = courseMapper.courseInDtoToCourse(courseInDto);
            course.setId(id);

            course.setPerson(personService.findByEmail(PersonUtil.EMAIL));

            course.setInstituteUniversity(instituteUniversityService
                    .findById(courseInDto.getInstituteUniversityId()));

            courseRepository.save(course);

            return courseMapper.courseToCourseDto(course);

        } else {

            throw new BadRequestException("The ID not exists");

        }

    }

}
