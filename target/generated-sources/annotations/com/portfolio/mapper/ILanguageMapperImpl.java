package com.portfolio.mapper;

import com.portfolio.dto.request.LanguageInDto;
import com.portfolio.dto.response.LanguageDto;
import com.portfolio.model.entity.Language;
import com.portfolio.model.entity.LanguageLevel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-20T17:33:23-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class ILanguageMapperImpl implements ILanguageMapper {

    @Override
    public LanguageDto languageToLanguageDto(Language language) {
        if ( language == null ) {
            return null;
        }

        LanguageDto languageDto = new LanguageDto();

        languageDto.setLanguageLevelName( languageLanguageLevelName( language ) );
        languageDto.setId( language.getId() );
        languageDto.setName( language.getName() );
        languageDto.setCertificateUrl( language.getCertificateUrl() );

        return languageDto;
    }

    @Override
    public Language LanguageInDtoToLanguage(LanguageInDto languageInDto) {
        if ( languageInDto == null ) {
            return null;
        }

        Language language = new Language();

        language.setName( languageInDto.getName() );
        language.setCertificateUrl( languageInDto.getCertificateUrl() );

        return language;
    }

    private String languageLanguageLevelName(Language language) {
        if ( language == null ) {
            return null;
        }
        LanguageLevel languageLevel = language.getLanguageLevel();
        if ( languageLevel == null ) {
            return null;
        }
        String name = languageLevel.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
