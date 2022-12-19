package com.portfolio.service.impl;

import com.portfolio.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {

    private final ICityService cityService;
    private final ICountryService countryService;
    private final ILocalityService localityService;
    private final IProvinceService provinceService;

    @Autowired
    public AddressServiceImpl(ICityService cityService,
                              ICountryService countryService,
                              ILocalityService localityService,
                              IProvinceService provinceService){
        this.cityService = cityService;
        this.countryService = countryService;
        this.localityService = localityService;
        this.provinceService = provinceService;
    }

    @Override
    public List<String> getAllCities() {
        return cityService.getAll();
    }

    @Override
    public List<String> getAllCountries() {
        return countryService.getAll();
    }

    @Override
    public List<String> getAllLocalities() {
        return localityService.getAll();
    }

    @Override
    public List<String> getAllProvinces() {
        return provinceService.getAll();
    }

}
