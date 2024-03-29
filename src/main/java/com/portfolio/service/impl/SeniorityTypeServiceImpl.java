package com.portfolio.service.impl;

import com.portfolio.model.entity.SeniorityType;
import com.portfolio.repository.ISeniorityTypeRepository;
import com.portfolio.service.ISeniorityTypeService;
import com.portfolio.util.ValidationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SeniorityTypeServiceImpl implements ISeniorityTypeService {

    private final ISeniorityTypeRepository seniorityTypeRepository;

    @Autowired
    public SeniorityTypeServiceImpl(ISeniorityTypeRepository seniorityTypeRepository){
        this.seniorityTypeRepository = seniorityTypeRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> getAllSeniorityTypes() {
        return seniorityTypeRepository.findAll()
                .stream()
                .map(SeniorityType::getName)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public SeniorityType findById(Integer id) {

        ValidationUtil.validateId(id);

        return seniorityTypeRepository.findById(id).orElseThrow();

    }

}
