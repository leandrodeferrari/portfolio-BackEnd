package com.portfolio.mapper;

import com.portfolio.dto.response.PersonDto;
import com.portfolio.model.entity.Person;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {IAddressMapper.class})
public interface IPersonMapper {

    @Mapping(target = "addressDto", source = "address")
    PersonDto personToPersonDto(Person person);

}
