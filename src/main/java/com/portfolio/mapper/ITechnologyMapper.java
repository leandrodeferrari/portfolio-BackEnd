package com.portfolio.mapper;

import com.portfolio.dto.request.TechnologyInDto;
import com.portfolio.dto.response.TechnologyDto;
import com.portfolio.model.entity.Technology;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ITechnologyMapper {

    TechnologyDto technologyToTechnologyDto(Technology technology);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "person", ignore = true)
    })
    Technology technologyInDtoToTechnology(TechnologyInDto technologyInDto);

}
