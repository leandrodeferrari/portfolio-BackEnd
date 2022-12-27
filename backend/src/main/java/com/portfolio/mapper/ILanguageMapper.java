package com.portfolio.mapper;

import com.portfolio.dto.request.LanguageInDto;
import com.portfolio.dto.response.LanguageDto;
import com.portfolio.model.entity.Language;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ILanguageMapper {

    @Mapping(target = "languageLevelName", source = "language.languageLevel.name")
    LanguageDto languageToLanguageDto(Language language);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "languageLevel", ignore = true),
            @Mapping(target = "person", ignore = true)
    })
    Language LanguageInDtoToLanguage(LanguageInDto languageInDto);

}
