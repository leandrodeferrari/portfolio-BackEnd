package com.portfolio.service.impl;

import com.portfolio.model.entity.Province;
import com.portfolio.repository.IProvinceRepository;
import com.portfolio.service.IProvinceService;
import com.portfolio.util.ValidationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Province findByName(String name) {

        ValidationUtil.validateName(name);

        return provinceRepository.findByName(name).orElseThrow();

    }

    @Transactional
    @Override
    public String create(String name) {

        ValidationUtil.validateName(name);

        Province province = new Province();
        province.setName(name);

        return provinceRepository.save(province).getName();

    }

}
