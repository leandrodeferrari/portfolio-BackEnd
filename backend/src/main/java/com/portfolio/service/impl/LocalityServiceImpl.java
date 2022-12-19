package com.portfolio.service.impl;

import com.portfolio.model.entity.Locality;
import com.portfolio.repository.ILocalityRepository;
import com.portfolio.service.ILocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
