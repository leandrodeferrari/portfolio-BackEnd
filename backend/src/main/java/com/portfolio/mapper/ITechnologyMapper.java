package com.portfolio.mapper;

import com.portfolio.dto.TechnologyDto;
import com.portfolio.model.entity.Technology;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITechnologyMapper {

    TechnologyDto technologyToTechnologyDto(Technology technology);

}
