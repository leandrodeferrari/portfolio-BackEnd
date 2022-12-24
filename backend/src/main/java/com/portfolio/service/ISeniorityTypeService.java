package com.portfolio.service;

import com.portfolio.model.entity.SeniorityType;

import java.util.List;

public interface ISeniorityTypeService {

    List<String> getAllSeniorityTypes();

    SeniorityType findById(Integer id);

}
