package com.portfolio.service;

import com.portfolio.dto.request.TechnologyInDto;
import com.portfolio.dto.response.TechnologyDto;

import java.util.List;

public interface ITechnologyService {

    List<TechnologyDto> getAll();

    void delete(Integer id);

    TechnologyDto create(TechnologyInDto technologyInDto);

}
