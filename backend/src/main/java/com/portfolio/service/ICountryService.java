package com.portfolio.service;

import com.portfolio.model.entity.Country;

import java.util.List;

public interface ICountryService {

    List<String> getAll();

    Country findByName(String name);

    String create(String name);

}
