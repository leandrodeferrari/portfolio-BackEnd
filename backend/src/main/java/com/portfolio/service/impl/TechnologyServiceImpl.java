package com.portfolio.service.impl;

import com.portfolio.dto.TechnologyDto;
import com.portfolio.mapper.ITechnologyMapper;
import com.portfolio.repository.ITechnologyRepository;
import com.portfolio.service.ITechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TechnologyServiceImpl implements ITechnologyService {

    private final ITechnologyMapper technologyMapper;
    private final ITechnologyRepository technologyRepository;

    @Autowired
    public TechnologyServiceImpl(ITechnologyMapper technologyMapper,
                                 ITechnologyRepository technologyRepository){
        this.technologyMapper = technologyMapper;
        this.technologyRepository = technologyRepository;
    }

    @Override
    public List<TechnologyDto> getAll() {
        return technologyRepository.findAll()
                .stream()
                .map(technologyMapper::technologyToTechnologyDto)
                .collect(Collectors.toList());
    }

}
