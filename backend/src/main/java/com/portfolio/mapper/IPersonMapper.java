package com.portfolio.mapper;

import com.portfolio.dto.response.AboutDto;
import com.portfolio.dto.response.ContactDto;
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

    @Mapping(target = "addressDto", source = "address")
    ContactDto personToContactDto(Person person);

    @Mapping(target = "fullName", expression = "java(person.getFirstName() + ' ' + person.getLastName())")
    AboutDto personToAboutDto(Person person);

}
