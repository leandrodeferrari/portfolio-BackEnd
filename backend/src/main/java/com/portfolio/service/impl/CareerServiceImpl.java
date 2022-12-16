package com.portfolio.service.impl;

import com.portfolio.dto.CareerDto;
import com.portfolio.mapper.ICareerMapper;
import com.portfolio.repository.ICareerRepository;
import com.portfolio.service.ICareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CareerServiceImpl implements ICareerService {

    private final ICareerRepository careerRepository;
    private final ICareerMapper careerMapper;

    @Autowired
    public CareerServiceImpl(ICareerRepository careerRepository, ICareerMapper careerMapper){
        this.careerRepository = careerRepository;
        this.careerMapper = careerMapper;
    }

    @Override
    public List<CareerDto> getAll() {
        return careerRepository.findAll()
                .stream()
                .map(careerMapper::careerToCareerDto).collect(Collectors.toList());
    }

}
