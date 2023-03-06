package com.portfolio.mapper;

import com.portfolio.dto.request.TechnologyInDto;
import com.portfolio.dto.response.TechnologyDto;
import com.portfolio.model.entity.Technology;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-06T18:41:41-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class ITechnologyMapperImpl implements ITechnologyMapper {

    @Override
    public TechnologyDto technologyToTechnologyDto(Technology technology) {
        if ( technology == null ) {
            return null;
        }

        TechnologyDto technologyDto = new TechnologyDto();

        technologyDto.setId( technology.getId() );
        technologyDto.setName( technology.getName() );
        technologyDto.setLogoUrl( technology.getLogoUrl() );

        return technologyDto;
    }

    @Override
    public Technology technologyInDtoToTechnology(TechnologyInDto technologyInDto) {
        if ( technologyInDto == null ) {
            return null;
        }

        Technology technology = new Technology();

        technology.setName( technologyInDto.getName() );
        technology.setLogoUrl( technologyInDto.getLogoUrl() );

        return technology;
    }
}
