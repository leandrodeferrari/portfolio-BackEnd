package com.portfolio.controller;

import com.portfolio.dto.request.AddressInDto;
import com.portfolio.dto.response.AddressDto;
import com.portfolio.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final IAddressService addressService;

    @Autowired
    public AddressController(IAddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping("/cities")
    public ResponseEntity<List<String>> getAllCities(){
        return ResponseEntity.ok().body(addressService.getAllCities());
    }

    @GetMapping("/countries")
    public ResponseEntity<List<String>> getAllCountries(){
        return ResponseEntity.ok().body(addressService.getAllCountries());
    }

    @GetMapping("/localities")
    public ResponseEntity<List<String>> getAllLocalities(){
        return ResponseEntity.ok().body(addressService.getAllLocalities());
    }

    @GetMapping("/provinces")
    public ResponseEntity<List<String>> getAllProvinces(){
        return ResponseEntity.ok().body(addressService.getAllProvinces());
    }

    @PostMapping
    public ResponseEntity<AddressDto> create(@Valid @RequestBody AddressInDto addressInDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.create(addressInDto));
    }

    @PostMapping("/cities")
    public ResponseEntity<String> createCity(@RequestParam("cityName") String cityName){
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.createCity(cityName));
    }

    @PostMapping("/countries")
    public ResponseEntity<String> createCountry(@RequestParam("countryName") String countryName){
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.createCountry(countryName));
    }

    @PostMapping("/localities")
    public ResponseEntity<String> createLocality(@RequestParam("localityName") String localityName){
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.createLocality(localityName));
    }

    @PostMapping("/provinces")
    public ResponseEntity<String> createProvince(@RequestParam("provinceName") String provinceName){
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.createProvince(provinceName));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDto> update(@Valid @RequestBody AddressInDto addressInDto,
                                             @PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.update(addressInDto, id));
    }

}
