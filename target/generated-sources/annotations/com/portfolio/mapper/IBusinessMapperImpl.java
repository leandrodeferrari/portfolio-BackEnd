package com.portfolio.mapper;

import com.portfolio.dto.request.BusinessInDto;
import com.portfolio.dto.response.BusinessDto;
import com.portfolio.model.entity.Business;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-16T00:04:12-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class IBusinessMapperImpl implements IBusinessMapper {

    private final IAddressMapper iAddressMapper;

    @Autowired
    public IBusinessMapperImpl(IAddressMapper iAddressMapper) {

        this.iAddressMapper = iAddressMapper;
    }

    @Override
    public BusinessDto businessToBusinessDto(Business business) {
        if ( business == null ) {
            return null;
        }

        BusinessDto businessDto = new BusinessDto();

        businessDto.setAddressDto( iAddressMapper.addressToAddressDto( business.getAddress() ) );
        businessDto.setId( business.getId() );
        businessDto.setName( business.getName() );
        businessDto.setLogoUrl( business.getLogoUrl() );

        return businessDto;
    }

    @Override
    public Business businessInDtoToBusiness(BusinessInDto businessInDto) {
        if ( businessInDto == null ) {
            return null;
        }

        Business business = new Business();

        business.setName( businessInDto.getName() );
        business.setLogoUrl( businessInDto.getLogoUrl() );

        return business;
    }
}
