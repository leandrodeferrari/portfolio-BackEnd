package com.portfolio.service;

import com.portfolio.dto.request.LanguageInDto;
import com.portfolio.dto.response.LanguageDto;

import java.util.List;

public interface ILanguageService {

    List<LanguageDto> getAll();

    void delete(Integer id);

    LanguageDto create(LanguageInDto languageInDto);

}
