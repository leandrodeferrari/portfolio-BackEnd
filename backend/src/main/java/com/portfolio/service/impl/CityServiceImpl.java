package com.portfolio.service.impl;

import com.portfolio.model.entity.City;
import com.portfolio.repository.ICityRepository;
import com.portfolio.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
