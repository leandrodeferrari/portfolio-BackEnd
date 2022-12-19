package com.portfolio.service.impl;

import com.portfolio.model.entity.Country;
import com.portfolio.repository.ICountryRepository;
import com.portfolio.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements ICountryService {

    private final ICountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(ICountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @Override
    public List<String> getAll() {
        return countryRepository.findAll()
                .stream()
                .map(Country::getName)
                .toList();
    }

}
