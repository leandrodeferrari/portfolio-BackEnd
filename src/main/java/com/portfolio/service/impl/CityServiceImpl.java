package com.portfolio.service.impl;

import com.portfolio.model.entity.City;
import com.portfolio.repository.ICityRepository;
import com.portfolio.service.ICityService;
import com.portfolio.util.ValidationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService {

    private final ICityRepository cityRepository;

    @Autowired
    public CityServiceImpl(ICityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @Override
    public List<String> getAll() {
        return cityRepository.findAll()
                .stream()
                .map(City::getName)
                .toList();
    }

    @Override
    public City findByName(String name) {

        ValidationUtil.validateName(name);

        return cityRepository.findByName(name).orElseThrow();

    }

    @Transactional
    @Override
    public String create(String name) {

        ValidationUtil.validateName(name);

        City city = new City();
        city.setName(name);

        return cityRepository.save(city).getName();

    }

}
