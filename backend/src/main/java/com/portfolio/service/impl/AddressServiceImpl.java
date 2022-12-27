package com.portfolio.service.impl;

import com.portfolio.dto.request.AddressInDto;
import com.portfolio.dto.response.AddressDto;
import com.portfolio.exception.BadRequestException;
import com.portfolio.mapper.IAddressMapper;
import com.portfolio.model.entity.Address;
import com.portfolio.repository.IAddressRepository;
import com.portfolio.service.*;
import com.portfolio.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@Service
public class AddressServiceImpl implements IAddressService {

    private final IAddressMapper addressMapper;
    private final IAddressRepository addressRepository;
    private final ICityService cityService;
    private final ICountryService countryService;
    private final ILocalityService localityService;
    private final IProvinceService provinceService;
    private final MessageSource messageSource;

    @Autowired
    public AddressServiceImpl(IAddressMapper addressMapper,
                              IAddressRepository addressRepository,
                              ICityService cityService,
                              ICountryService countryService,
                              ILocalityService localityService,
                              IProvinceService provinceService,
                              MessageSource messageSource){
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
        this.cityService = cityService;
        this.countryService = countryService;
        this.localityService = localityService;
        this.provinceService = provinceService;
        this.messageSource = messageSource;
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

    @Transactional
    @Override
    public AddressDto create(AddressInDto addressInDto) {

        Address address = new Address();
        address.setCity(cityService.findByName(addressInDto.getCityName()));
        address.setCountry(countryService.findByName(addressInDto.getCountryName()));
        address.setLocality(localityService.findByName(addressInDto.getLocalityName()));
        address.setProvince(provinceService.findByName(addressInDto.getProvinceName()));

        addressRepository.save(address);

        return addressMapper.addressToAddressDto(address);

    }

    @Override
    public String createCity(String cityName) {
        return cityService.create(cityName);
    }

    @Override
    public String createCountry(String countryName) {
        return countryService.create(countryName);
    }

    @Override
    public String createLocality(String localityName) {
        return localityService.create(localityName);
    }

    @Override
    public String createProvince(String provinceName) {
        return provinceService.create(provinceName);
    }

    @Transactional
    @Override
    public AddressDto update(AddressInDto addressInDto, Integer id) {

        ValidationUtil.validateId(id);

        if(addressRepository.existsById(id)){

            Address address = new Address();
            address.setId(id);
            address.setCity(cityService.findByName(addressInDto.getCityName()));
            address.setCountry(countryService.findByName(addressInDto.getCountryName()));
            address.setLocality(localityService.findByName(addressInDto.getLocalityName()));
            address.setProvince(provinceService.findByName(addressInDto.getProvinceName()));

            addressRepository.save(address);

            return addressMapper.addressToAddressDto(address);

        } else {

            throw new BadRequestException(messageSource.getMessage("validation.id.not.exists", null, Locale.getDefault()));

        }

    }

}
