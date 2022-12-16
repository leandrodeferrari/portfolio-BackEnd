package com.portfolio.mapper;

import com.portfolio.dto.BusinessDto;
import com.portfolio.model.entity.Business;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {IAddressMapper.class})
public interface IBusinessMapper {

    @Mapping(target = "addressDto", source = "address")
    BusinessDto businessToBusinessDto(Business business);

}
