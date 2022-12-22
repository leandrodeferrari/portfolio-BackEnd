package com.portfolio.mapper;

import com.portfolio.dto.response.LanguageDto;
import com.portfolio.model.entity.Language;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ILanguageMapper {

    @Mapping(target = "languageLevelName", source = "language.languageLevel.name")
    LanguageDto languageToLanguageDto(Language language);

}
