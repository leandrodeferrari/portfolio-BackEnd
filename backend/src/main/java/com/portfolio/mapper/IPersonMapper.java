package com.portfolio.mapper;

import com.portfolio.dto.PersonDto;
import com.portfolio.model.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IPersonMapper {

    @Mapping(target = "addressDto", ignore = true)
    PersonDto personToPersonDto(Person person);

}
