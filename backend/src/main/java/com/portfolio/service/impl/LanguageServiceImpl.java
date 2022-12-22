package com.portfolio.service.impl;

import com.portfolio.dto.response.LanguageDto;
import com.portfolio.mapper.ILanguageMapper;
import com.portfolio.repository.ILanguageRepository;
import com.portfolio.service.ILanguageService;
import com.portfolio.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements ILanguageService {

    private final ILanguageMapper languageMapper;
    private final ILanguageRepository languageRepository;

    @Autowired
    public LanguageServiceImpl(ILanguageMapper languageMapper, ILanguageRepository languageRepository){
        this.languageMapper = languageMapper;
        this.languageRepository = languageRepository;
    }

    @Override
    public List<LanguageDto> getAll() {
        return languageRepository.findAll()
                .stream()
                .map(languageMapper::languageToLanguageDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void delete(Integer id) {

        ValidationUtil.validateId(id);
        languageRepository.findById(id).orElseThrow();

        languageRepository.deleteById(id);

    }

}
