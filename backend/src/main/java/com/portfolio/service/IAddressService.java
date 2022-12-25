package com.portfolio.service;

import com.portfolio.dto.request.AddressInDto;
import com.portfolio.dto.response.AddressDto;
import com.portfolio.model.entity.Address;

import java.util.List;

public interface IAddressService {

    List<String> getAllCities();

    List<String> getAllLocalities();

    List<String> getAllProvinces();

    List<String> getAllCountries();

    Address findById(Integer id);

    AddressDto create(AddressInDto addressInDto);

    String createCity(String cityName);

    String createLocality(String localityName);

    String createProvince(String provinceName);

    String createCountry(String countryName);

}
