package com.portfolio.service.impl;

import com.portfolio.model.entity.Country;
import com.portfolio.repository.ICountryRepository;
import com.portfolio.service.ICountryService;
import com.portfolio.util.ValidationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements ICountryService {

    private final ICountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(ICountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> getAll() {
        return countryRepository.findAll()
                .stream()
                .map(Country::getName)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public Country findByName(String name) {

        ValidationUtil.validateName(name);

        return countryRepository.findByName(name).orElseThrow();

    }

    @Transactional
    @Override
    public String create(String name) {

        ValidationUtil.validateName(name);

        Country country = new Country();
        country.setName(name);

        return countryRepository.save(country).getName();

    }

}
