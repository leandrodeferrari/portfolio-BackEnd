package com.portfolio.service;

import com.portfolio.model.entity.City;

import java.util.List;

public interface ICityService {

    List<String> getAll();

    City findByName(String name);

    String create(String name);

}
