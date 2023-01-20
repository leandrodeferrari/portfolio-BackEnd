package com.portfolio.service;

import com.portfolio.model.entity.LanguageLevel;

import java.util.List;

public interface ILanguageLevelService {

    List<String> getAllLevels();
    LanguageLevel findById(Integer id);

}
