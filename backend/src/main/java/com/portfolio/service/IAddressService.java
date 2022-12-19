package com.portfolio.service;

import java.util.List;

public interface IAddressService {

    List<String> getAllCities();

    List<String> getAllLocalities();

    List<String> getAllProvinces();

    List<String> getAllCountries();

}
