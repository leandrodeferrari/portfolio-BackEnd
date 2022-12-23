package com.portfolio.mapper;

import com.portfolio.dto.request.CareerInDto;
import com.portfolio.dto.response.CareerDto;
import com.portfolio.model.entity.Career;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {IInstituteUniversityMapper.class})
public interface ICareerMapper {

    @Mappings({
            @Mapping(target = "startDate", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "endDate", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "instituteUniversityDto", source = "instituteUniversity"),
            @Mapping(target = "careerTypeName", source = "career.careerType.name")
    })
    CareerDto careerToCareerDto(Career career);

    @Mappings({
            @Mapping(target = "careerType", ignore = true),
            @Mapping(target = "instituteUniversity", ignore = true),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "person", ignore = true)
    })
    Career careerInDtoToCareer(CareerInDto careerInDto);

}
