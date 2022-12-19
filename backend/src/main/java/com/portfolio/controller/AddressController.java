package com.portfolio.controller;

import com.portfolio.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
