package com.portfolio.mapper;

import com.portfolio.dto.response.AddressDto;
import com.portfolio.model.entity.Address;
import com.portfolio.model.entity.City;
import com.portfolio.model.entity.Country;
import com.portfolio.model.entity.Locality;
import com.portfolio.model.entity.Province;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-20T17:33:23-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class IAddressMapperImpl implements IAddressMapper {

    @Override
    public AddressDto addressToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setCityName( addressCityName( address ) );
        addressDto.setLocalityName( addressLocalityName( address ) );
        addressDto.setProvinceName( addressProvinceName( address ) );
        addressDto.setCountryName( addressCountryName( address ) );
        addressDto.setId( address.getId() );

        return addressDto;
    }

    private String addressCityName(Address address) {
        if ( address == null ) {
            return null;
        }
        City city = address.getCity();
        if ( city == null ) {
            return null;
        }
        String name = city.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String addressLocalityName(Address address) {
        if ( address == null ) {
            return null;
        }
        Locality locality = address.getLocality();
        if ( locality == null ) {
            return null;
        }
        String name = locality.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String addressProvinceName(Address address) {
        if ( address == null ) {
            return null;
        }
        Province province = address.getProvince();
        if ( province == null ) {
            return null;
        }
        String name = province.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String addressCountryName(Address address) {
        if ( address == null ) {
            return null;
        }
        Country country = address.getCountry();
        if ( country == null ) {
            return null;
        }
        String name = country.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
