package com.portfolio.service;

import com.portfolio.dto.TechnologyDto;

import java.util.List;

public interface ITechnologyService {

    List<TechnologyDto> getAll();

    void delete(Integer id);

}
