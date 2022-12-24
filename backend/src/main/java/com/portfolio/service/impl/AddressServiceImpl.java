package com.portfolio.service.impl;

import com.portfolio.model.entity.Address;
import com.portfolio.repository.IAddressRepository;
import com.portfolio.service.*;
import com.portfolio.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {

    private final IAddressRepository addressRepository;
    private final ICityService cityService;
    private final ICountryService countryService;
    private final ILocalityService localityService;
    private final IProvinceService provinceService;

    @Autowired
    public AddressServiceImpl(IAddressRepository addressRepository,
                              ICityService cityService,
                              ICountryService countryService,
                              ILocalityService localityService,
                              IProvinceService provinceService){
        this.addressRepository = addressRepository;
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

    @Override
    public Address findById(Integer id) {

        ValidationUtil.validateId(id);

        return addressRepository.findById(id).orElseThrow();

    }

}
