package com.portfolio.service.impl;

import com.portfolio.model.entity.SeniorityType;
import com.portfolio.repository.ISeniorityTypeRepository;
import com.portfolio.service.ISeniorityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeniorityTypeServiceImpl implements ISeniorityTypeService {

    private final ISeniorityTypeRepository seniorityTypeRepository;

    @Autowired
    public SeniorityTypeServiceImpl(ISeniorityTypeRepository seniorityTypeRepository){
        this.seniorityTypeRepository = seniorityTypeRepository;
    }

    @Override
    public List<String> getAllSeniorityTypes() {
        return seniorityTypeRepository.findAll()
                .stream()
                .map(SeniorityType::getName)
                .toList();
    }

}
