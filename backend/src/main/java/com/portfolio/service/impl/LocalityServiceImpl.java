package com.portfolio.service.impl;

import com.portfolio.model.entity.Locality;
import com.portfolio.repository.ILocalityRepository;
import com.portfolio.service.ILocalityService;
import com.portfolio.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocalityServiceImpl implements ILocalityService {

    private final ILocalityRepository localityRepository;

    @Autowired
    public LocalityServiceImpl(ILocalityRepository localityRepository){
        this.localityRepository = localityRepository;
    }

    @Override
    public List<String> getAll() {
        return localityRepository.findAll()
                .stream()
                .map(Locality::getName)
                .toList();
    }

    @Override
    public Locality findByName(String name) {

        ValidationUtil.validateName(name);

        return localityRepository.findByName(name).orElseThrow();

    }

    @Transactional
    @Override
    public String create(String name) {

        ValidationUtil.validateName(name);

        Locality locality = new Locality();
        locality.setName(name);

        return localityRepository.save(locality).getName();

    }

}
