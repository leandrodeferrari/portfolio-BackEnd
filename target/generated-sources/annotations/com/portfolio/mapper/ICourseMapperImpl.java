package com.portfolio.mapper;

import com.portfolio.dto.request.CourseInDto;
import com.portfolio.dto.response.CourseDto;
import com.portfolio.model.entity.Course;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-06T12:48:22-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class ICourseMapperImpl implements ICourseMapper {

    private final IInstituteUniversityMapper iInstituteUniversityMapper;
    private final DateTimeFormatter dateTimeFormatter_MM_yyyy_11869881679 = DateTimeFormatter.ofPattern( "MM/yyyy" );

    @Autowired
    public ICourseMapperImpl(IInstituteUniversityMapper iInstituteUniversityMapper) {

        this.iInstituteUniversityMapper = iInstituteUniversityMapper;
    }

    @Override
    public CourseDto courseToCourseDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        if ( course.getStartDate() != null ) {
            courseDto.setStartDate( dateTimeFormatter_MM_yyyy_11869881679.format( course.getStartDate() ) );
        }
        if ( course.getEndDate() != null ) {
            courseDto.setEndDate( dateTimeFormatter_MM_yyyy_11869881679.format( course.getEndDate() ) );
        }
        courseDto.setInstituteUniversityDto( iInstituteUniversityMapper.instituteUniversityToInstituteUniversityDto( course.getInstituteUniversity() ) );
        courseDto.setId( course.getId() );
        courseDto.setTitle( course.getTitle() );
        courseDto.setApproved( course.isApproved() );
        courseDto.setCertificateUrl( course.getCertificateUrl() );

        return courseDto;
    }

    @Override
    public Course courseInDtoToCourse(CourseInDto courseInDto) {
        if ( courseInDto == null ) {
            return null;
        }

        Course course = new Course();

        course.setTitle( courseInDto.getTitle() );
        course.setApproved( courseInDto.isApproved() );
        course.setCertificateUrl( courseInDto.getCertificateUrl() );
        course.setStartDate( courseInDto.getStartDate() );
        course.setEndDate( courseInDto.getEndDate() );

        return course;
    }
}
