package com.portfolio.mapper;

import com.portfolio.dto.request.BusinessInDto;
import com.portfolio.dto.response.BusinessDto;
import com.portfolio.model.entity.Business;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {IAddressMapper.class})
public interface IBusinessMapper {

    @Mapping(target = "addressDto", source = "address")
    BusinessDto businessToBusinessDto(Business business);

    @Mappings({
            @Mapping(target = "address", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    Business businessInDtoToBusiness(BusinessInDto businessInDto);

}
