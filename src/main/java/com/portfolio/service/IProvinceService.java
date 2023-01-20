package com.portfolio.service;

import com.portfolio.model.entity.Province;

import java.util.List;

public interface IProvinceService {

    List<String> getAll();
    Province findByName(String name);
    String create(String name);

}
