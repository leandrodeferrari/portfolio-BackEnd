package com.portfolio.service.impl;

import com.portfolio.dto.request.InstituteUniversityInDto;
import com.portfolio.dto.response.InstituteUniversityDto;
import com.portfolio.mapper.IInstituteUniversityMapper;
import com.portfolio.model.entity.InstituteUniversity;
import com.portfolio.repository.IInstituteUniversityRepository;
import com.portfolio.service.IAddressService;
import com.portfolio.service.IInstituteUniversityService;
import com.portfolio.util.ValidationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstituteUniversityServiceImpl implements IInstituteUniversityService {

    private final IAddressService addressService;
    private final IInstituteUniversityMapper instituteUniversityMapper;
    private final IInstituteUniversityRepository instituteUniversityRepository;

    @Autowired
    public InstituteUniversityServiceImpl(IAddressService addressService,
                                          IInstituteUniversityMapper instituteUniversityMapper,
                                          IInstituteUniversityRepository instituteUniversityRepository){
        this.addressService = addressService;
        this.instituteUniversityMapper = instituteUniversityMapper;
        this.instituteUniversityRepository = instituteUniversityRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<InstituteUniversityDto> getAll() {
        return instituteUniversityRepository.findAll()
                .stream()
                .map(instituteUniversityMapper::instituteUniversityToInstituteUniversityDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public InstituteUniversity findById(Integer id) {

        ValidationUtil.validateId(id);

        return instituteUniversityRepository.findById(id).orElseThrow();

    }

    @Transactional
    @Override
    public InstituteUniversityDto create(InstituteUniversityInDto instituteUniversityInDto) {

        InstituteUniversity instituteUniversity = instituteUniversityMapper
                .instituteUniversityInDtoToInstituteUniversity(instituteUniversityInDto);

        instituteUniversity.setAddress(addressService.findById(instituteUniversityInDto.getAddressId()));

        instituteUniversityRepository.save(instituteUniversity);

        return instituteUniversityMapper.instituteUniversityToInstituteUniversityDto(instituteUniversity);

    }

}
