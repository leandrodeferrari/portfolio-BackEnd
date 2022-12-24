package com.portfolio.service;

import com.portfolio.model.entity.Address;

import java.util.List;

public interface IAddressService {

    List<String> getAllCities();

    List<String> getAllLocalities();

    List<String> getAllProvinces();

    List<String> getAllCountries();

    Address findById(Integer id);

}
