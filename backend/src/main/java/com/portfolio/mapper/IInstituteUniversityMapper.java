package com.portfolio.mapper;

import com.portfolio.dto.response.InstituteUniversityDto;
import com.portfolio.model.entity.InstituteUniversity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {IAddressMapper.class})
public interface IInstituteUniversityMapper {

    @Mapping(target = "addressDto", source = "address")
    InstituteUniversityDto instituteUniversityToInstituteUniversityDto(InstituteUniversity instituteUniversity);

}
