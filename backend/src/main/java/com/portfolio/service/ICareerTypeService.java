package com.portfolio.service;

import com.portfolio.model.entity.CareerType;

import java.util.List;

public interface ICareerTypeService {

    List<String> getAllTypes();

    CareerType findById(Integer id);

}
