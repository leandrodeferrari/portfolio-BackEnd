package com.portfolio.mapper;

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

}
