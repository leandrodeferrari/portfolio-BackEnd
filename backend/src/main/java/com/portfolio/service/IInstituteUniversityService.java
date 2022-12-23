package com.portfolio.service;

import com.portfolio.dto.response.InstituteUniversityDto;
import com.portfolio.model.entity.InstituteUniversity;

import java.util.List;

public interface IInstituteUniversityService {

    List<InstituteUniversityDto> getAll();

    InstituteUniversity findById(Integer id);

}
