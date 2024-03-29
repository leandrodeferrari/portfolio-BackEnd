package com.portfolio.service.impl;

import com.portfolio.model.entity.CareerType;
import com.portfolio.repository.ICareerTypeRepository;
import com.portfolio.service.ICareerTypeService;
import com.portfolio.util.ValidationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CareerTypeServiceImpl implements ICareerTypeService {

    private final ICareerTypeRepository careerTypeRepository;

    @Autowired
    public CareerTypeServiceImpl(ICareerTypeRepository careerTypeRepository){
        this.careerTypeRepository = careerTypeRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> getAllTypes() {
        return careerTypeRepository.findAll()
                .stream()
                .map(CareerType::getName)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public CareerType findById(Integer id) {

        ValidationUtil.validateId(id);

        return careerTypeRepository.findById(id).orElseThrow();

    }

}
