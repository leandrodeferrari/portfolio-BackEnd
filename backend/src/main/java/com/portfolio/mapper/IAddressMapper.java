package com.portfolio.mapper;

import com.portfolio.dto.AddressDto;
import com.portfolio.model.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IAddressMapper {

    @Mappings({
            @Mapping(target = "cityName", source = "address.city.name"),
            @Mapping(target = "localityName", source = "address.locality.name"),
            @Mapping(target = "provinceName", source = "address.province.name"),
            @Mapping(target = "countryName", source = "address.country.name")
    })
    AddressDto addressToAddressDto(Address address);

}
