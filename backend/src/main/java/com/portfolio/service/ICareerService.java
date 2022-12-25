package com.portfolio.service;

import com.portfolio.dto.request.CareerInDto;
import com.portfolio.dto.response.CareerDto;

import java.util.List;

public interface ICareerService {

    List<CareerDto> getAll();
    void delete(Integer id);
    CareerDto create(CareerInDto careerInDto);
    CareerDto update(CareerInDto careerInDto, Integer id);

}
