package com.portfolio.mapper;

import com.portfolio.dto.request.InstituteUniversityInDto;
import com.portfolio.dto.response.InstituteUniversityDto;
import com.portfolio.model.entity.InstituteUniversity;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {IAddressMapper.class})
public interface IInstituteUniversityMapper {

    @Mapping(target = "addressDto", source = "address")
    InstituteUniversityDto instituteUniversityToInstituteUniversityDto(InstituteUniversity instituteUniversity);

    @Mappings({
            @Mapping(target = "address", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    InstituteUniversity instituteUniversityInDtoToInstituteUniversity(InstituteUniversityInDto instituteUniversityInDto);

}
