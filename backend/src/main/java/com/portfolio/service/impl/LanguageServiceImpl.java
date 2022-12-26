package com.portfolio.service.impl;

import com.portfolio.dto.request.LanguageInDto;
import com.portfolio.dto.response.LanguageDto;
import com.portfolio.exception.BadRequestException;
import com.portfolio.mapper.ILanguageMapper;
import com.portfolio.model.entity.Language;
import com.portfolio.repository.ILanguageRepository;
import com.portfolio.service.ILanguageLevelService;
import com.portfolio.service.ILanguageService;
import com.portfolio.service.IPersonService;
import com.portfolio.util.PersonUtil;
import com.portfolio.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements ILanguageService {

    private final ILanguageLevelService languageLevelService;
    private final ILanguageMapper languageMapper;
    private final ILanguageRepository languageRepository;
    private final IPersonService personService;

    @Autowired
    public LanguageServiceImpl(ILanguageLevelService languageLevelService,
                               ILanguageMapper languageMapper,
                               ILanguageRepository languageRepository,
                               IPersonService personService){
        this.languageLevelService = languageLevelService;
        this.languageMapper = languageMapper;
        this.languageRepository = languageRepository;
        this.personService = personService;
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

    @Transactional
    @Override
    public LanguageDto create(LanguageInDto languageInDto) {

        Language language = languageMapper.LanguageInDtoToLanguage(languageInDto);

        language.setPerson(personService.findByEmail(PersonUtil.EMAIL));

        language.setLanguageLevel(languageLevelService
                .findById(languageInDto.getLanguageLevelId()));

        languageRepository.save(language);

        return languageMapper.languageToLanguageDto(language);

    }

    @Transactional
    @Override
    public LanguageDto update(LanguageInDto languageInDto, Integer id) {

        ValidationUtil.validateId(id);

        if(languageRepository.existsById(id)){

            Language language = languageMapper.LanguageInDtoToLanguage(languageInDto);
            language.setId(id);

            language.setPerson(personService.findByEmail(PersonUtil.EMAIL));

            language.setLanguageLevel(languageLevelService
                    .findById(languageInDto.getLanguageLevelId()));

            languageRepository.save(language);

            return languageMapper.languageToLanguageDto(language);

        } else {

            throw new BadRequestException("The ID not exists");

        }

    }

}
