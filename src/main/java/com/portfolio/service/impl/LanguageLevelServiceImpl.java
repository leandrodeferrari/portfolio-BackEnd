package com.portfolio.service.impl;

import com.portfolio.model.entity.LanguageLevel;
import com.portfolio.repository.ILanguageLevelRepository;
import com.portfolio.service.ILanguageLevelService;
import com.portfolio.util.ValidationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LanguageLevelServiceImpl implements ILanguageLevelService {

    private final ILanguageLevelRepository languageLevelRepository;

    @Autowired
    public LanguageLevelServiceImpl(ILanguageLevelRepository languageLevelRepository){
        this.languageLevelRepository = languageLevelRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> getAllLevels() {
        return languageLevelRepository.findAll()
                .stream()
                .map(LanguageLevel::getName)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public LanguageLevel findById(Integer id) {

        ValidationUtil.validateId(id);

        return languageLevelRepository.findById(id).orElseThrow();

    }

}
