package com.portfolio.mapper;

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
            @Mapping(target = "startDate", dateFormat = "dd.MM.yyyy"),
            @Mapping(target = "endDate", dateFormat = "dd.MM.yyyy"),
            @Mapping(target = "instituteUniversityDto", source = "instituteUniversity"),
            @Mapping(target = "careerTypeName", source = "career.careerType.name")
    })
    CareerDto careerToCareerDto(Career career);

}
