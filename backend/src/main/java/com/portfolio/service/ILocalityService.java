package com.portfolio.service;

import com.portfolio.model.entity.Locality;

import java.util.List;

public interface ILocalityService {

    List<String> getAll();
    Locality findByName(String name);
    String create(String name);

}
