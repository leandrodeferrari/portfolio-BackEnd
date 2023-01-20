package com.portfolio.mapper;

import com.portfolio.dto.request.CareerInDto;
import com.portfolio.dto.response.CareerDto;
import com.portfolio.model.entity.Career;
import com.portfolio.model.entity.CareerType;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-20T17:33:23-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class ICareerMapperImpl implements ICareerMapper {

    private final IInstituteUniversityMapper iInstituteUniversityMapper;
    private final DateTimeFormatter dateTimeFormatter_MM_yyyy_11869881679 = DateTimeFormatter.ofPattern( "MM/yyyy" );

    @Autowired
    public ICareerMapperImpl(IInstituteUniversityMapper iInstituteUniversityMapper) {

        this.iInstituteUniversityMapper = iInstituteUniversityMapper;
    }

    @Override
    public CareerDto careerToCareerDto(Career career) {
        if ( career == null ) {
            return null;
        }

        CareerDto careerDto = new CareerDto();

        if ( career.getStartDate() != null ) {
            careerDto.setStartDate( dateTimeFormatter_MM_yyyy_11869881679.format( career.getStartDate() ) );
        }
        if ( career.getEndDate() != null ) {
            careerDto.setEndDate( dateTimeFormatter_MM_yyyy_11869881679.format( career.getEndDate() ) );
        }
        careerDto.setInstituteUniversityDto( iInstituteUniversityMapper.instituteUniversityToInstituteUniversityDto( career.getInstituteUniversity() ) );
        careerDto.setCareerTypeName( careerCareerTypeName( career ) );
        careerDto.setId( career.getId() );
        careerDto.setName( career.getName() );
        careerDto.setFinished( career.isFinished() );
        careerDto.setApprovedSubjects( career.getApprovedSubjects() );
        careerDto.setTotalSubjects( career.getTotalSubjects() );
        careerDto.setStudyPlanUrl( career.getStudyPlanUrl() );
        careerDto.setDescription( career.getDescription() );

        return careerDto;
    }

    @Override
    public Career careerInDtoToCareer(CareerInDto careerInDto) {
        if ( careerInDto == null ) {
            return null;
        }

        Career career = new Career();

        career.setName( careerInDto.getName() );
        career.setStartDate( careerInDto.getStartDate() );
        career.setEndDate( careerInDto.getEndDate() );
        career.setFinished( careerInDto.isFinished() );
        career.setApprovedSubjects( careerInDto.getApprovedSubjects() );
        career.setTotalSubjects( careerInDto.getTotalSubjects() );
        career.setStudyPlanUrl( careerInDto.getStudyPlanUrl() );
        career.setDescription( careerInDto.getDescription() );

        return career;
    }

    private String careerCareerTypeName(Career career) {
        if ( career == null ) {
            return null;
        }
        CareerType careerType = career.getCareerType();
        if ( careerType == null ) {
            return null;
        }
        String name = careerType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
