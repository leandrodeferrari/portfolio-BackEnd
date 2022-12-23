package com.portfolio.mapper;

import com.portfolio.dto.request.CourseInDto;
import com.portfolio.dto.response.CourseDto;
import com.portfolio.model.entity.Course;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {IInstituteUniversityMapper.class})
public interface ICourseMapper {

    @Mappings({
            @Mapping(target = "startDate", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "endDate", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "instituteUniversityDto", source = "instituteUniversity")
    })
    CourseDto courseToCourseDto(Course course);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "instituteUniversity", ignore = true),
            @Mapping(target = "person", ignore = true)
    })
    Course courseInDtoToCourse(CourseInDto courseInDto);

}
