package com.portfolio.service.impl;

import com.portfolio.model.entity.Province;
import com.portfolio.repository.IProvinceRepository;
import com.portfolio.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements IProvinceService {

    private final IProvinceRepository provinceRepository;

    @Autowired
    public ProvinceServiceImpl(IProvinceRepository provinceRepository){
        this.provinceRepository = provinceRepository;
    }

    @Override
    public List<String> getAll() {
        return provinceRepository.findAll()
                .stream()
                .map(Province::getName)
                .toList();
    }

}
