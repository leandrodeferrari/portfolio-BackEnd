package com.portfolio.service.impl;

import com.portfolio.dto.response.BusinessDto;
import com.portfolio.mapper.IBusinessMapper;
import com.portfolio.model.entity.Business;
import com.portfolio.repository.IBusinessRepository;
import com.portfolio.service.IBusinessService;
import com.portfolio.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessServiceImpl implements IBusinessService {

    private final IBusinessMapper businessMapper;
    private final IBusinessRepository businessRepository;

    @Autowired
    public BusinessServiceImpl(IBusinessMapper businessMapper,
                               IBusinessRepository businessRepository){
        this.businessMapper = businessMapper;
        this.businessRepository = businessRepository;
    }

    @Override
    public List<BusinessDto> getAll() {
        return businessRepository.findAll()
                .stream()
                .map(businessMapper::businessToBusinessDto)
                .collect(Collectors.toList());
    }

    @Override
    public Business findById(Integer id) {

        ValidationUtil.validateId(id);

        return businessRepository.findById(id).orElseThrow();

    }

}
