package com.portfolio.mapper;

import com.portfolio.dto.request.InstituteUniversityInDto;
import com.portfolio.dto.response.InstituteUniversityDto;
import com.portfolio.model.entity.InstituteUniversity;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-06T12:48:22-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class IInstituteUniversityMapperImpl implements IInstituteUniversityMapper {

    private final IAddressMapper iAddressMapper;

    @Autowired
    public IInstituteUniversityMapperImpl(IAddressMapper iAddressMapper) {

        this.iAddressMapper = iAddressMapper;
    }

    @Override
    public InstituteUniversityDto instituteUniversityToInstituteUniversityDto(InstituteUniversity instituteUniversity) {
        if ( instituteUniversity == null ) {
            return null;
        }

        InstituteUniversityDto instituteUniversityDto = new InstituteUniversityDto();

        instituteUniversityDto.setAddressDto( iAddressMapper.addressToAddressDto( instituteUniversity.getAddress() ) );
        instituteUniversityDto.setId( instituteUniversity.getId() );
        instituteUniversityDto.setName( instituteUniversity.getName() );
        instituteUniversityDto.setLogoUrl( instituteUniversity.getLogoUrl() );

        return instituteUniversityDto;
    }

    @Override
    public InstituteUniversity instituteUniversityInDtoToInstituteUniversity(InstituteUniversityInDto instituteUniversityInDto) {
        if ( instituteUniversityInDto == null ) {
            return null;
        }

        InstituteUniversity instituteUniversity = new InstituteUniversity();

        instituteUniversity.setName( instituteUniversityInDto.getName() );
        instituteUniversity.setLogoUrl( instituteUniversityInDto.getLogoUrl() );

        return instituteUniversity;
    }
}
