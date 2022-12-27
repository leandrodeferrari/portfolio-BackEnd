package com.portfolio.service;

import com.portfolio.dto.request.BusinessInDto;
import com.portfolio.dto.response.BusinessDto;
import com.portfolio.model.entity.Business;

import java.util.List;

public interface IBusinessService {

    List<BusinessDto> getAll();
    Business findById(Integer id);
    BusinessDto create(BusinessInDto businessInDto);

}
