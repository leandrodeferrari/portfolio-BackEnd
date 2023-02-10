package com.portfolio.controller;

import com.portfolio.dto.request.AddressInDto;
import com.portfolio.dto.response.AddressDto;
import com.portfolio.service.IAddressService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@CrossOrigin(origins = "https://leandro-deferrari.web.app")
@Tag(name = "Address", description = "Address Controller")
@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final IAddressService addressService;

    @Autowired
    public AddressController(IAddressService addressService){
        this.addressService = addressService;
    }

    @Operation(description = "Get All Cities. Any User. Parameters: none")
    @GetMapping("/cities")
    public ResponseEntity<List<String>> getAllCities(){
        return ResponseEntity.ok().body(addressService.getAllCities());
    }

    @Operation(description = "Get All Countries. Any User. Parameters: none")
    @GetMapping("/countries")
    public ResponseEntity<List<String>> getAllCountries(){
        return ResponseEntity.ok().body(addressService.getAllCountries());
    }

    @Operation(description = "Get All Localities. Any User. Parameters: none")
    @GetMapping("/localities")
    public ResponseEntity<List<String>> getAllLocalities(){
        return ResponseEntity.ok().body(addressService.getAllLocalities());
    }

    @Operation(description = "Get All Provinces. Any User. Parameters: none")
    @GetMapping("/provinces")
    public ResponseEntity<List<String>> getAllProvinces(){
        return ResponseEntity.ok().body(addressService.getAllProvinces());
    }

    @Operation(description = "Create an Address. User Authenticated. Parameters: Schema AddressInDto.")
    @PostMapping
    public ResponseEntity<AddressDto> create(@Valid @RequestBody AddressInDto addressInDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.create(addressInDto));
    }

    @Operation(description = "Create a City. User Authenticated. Parameters: Query Param cityName.")
    @PostMapping("/cities")
    public ResponseEntity<String> createCity(@RequestParam("cityName") String cityName){
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.createCity(cityName));
    }

    @Operation(description = "Create a Country. User Authenticated. Parameters: Query Param countryName.")
    @PostMapping("/countries")
    public ResponseEntity<String> createCountry(@RequestParam("countryName") String countryName){
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.createCountry(countryName));
    }

    @Operation(description = "Create a Locality. User Authenticated. Parameters: Query Param localityName.")
    @PostMapping("/localities")
    public ResponseEntity<String> createLocality(@RequestParam("localityName") String localityName){
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.createLocality(localityName));
    }

    @Operation(description = "Create a Province. User Authenticated. Parameters: Query Param provinceName.")
    @PostMapping("/provinces")
    public ResponseEntity<String> createProvince(@RequestParam("provinceName") String provinceName){
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.createProvince(provinceName));
    }

    @Operation(description = "Update an Address. User Authenticated. Parameters: Schema AddressInDto, Path Variable id.")
    @PutMapping("/{id}")
    public ResponseEntity<AddressDto> update(@Valid @RequestBody AddressInDto addressInDto,
                                             @PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.update(addressInDto, id));
    }

}
