package com.portfolio.service.impl;

import com.portfolio.dto.InstituteUniversityDto;
import com.portfolio.mapper.IInstituteUniversityMapper;
import com.portfolio.repository.IInstituteUniversityRepository;
import com.portfolio.service.IInstituteUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstituteUniversityServiceImpl implements IInstituteUniversityService {

    private final IInstituteUniversityMapper instituteUniversityMapper;
    private final IInstituteUniversityRepository instituteUniversityRepository;

    @Autowired
    public InstituteUniversityServiceImpl(IInstituteUniversityMapper instituteUniversityMapper,
                                          IInstituteUniversityRepository instituteUniversityRepository){
        this.instituteUniversityMapper = instituteUniversityMapper;
        this.instituteUniversityRepository = instituteUniversityRepository;
    }

    @Override
    public List<InstituteUniversityDto> getAll() {
        return instituteUniversityRepository.findAll()
                .stream()
                .map(instituteUniversityMapper::instituteUniversityToInstituteUniversityDto)
                .collect(Collectors.toList());
    }

}
