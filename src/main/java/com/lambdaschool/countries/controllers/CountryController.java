package com.lambdaschool.countries.controllers;

import com.lambdaschool.countries.models.Country;
import com.lambdaschool.countries.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {
//    private List<Country> findCountries(List<Country> countryList, CheckCountry tester)

//    @Autowired
//    CountryRepository countryrepos;

    @Autowired
    CountryRepository countryrepos;

    // http://localhot:2020/names/all
    @GetMapping(value = "/names/all", produces = {"application/json"})
    public ResponseEntity<?> listAllCountries()
    {
        List<Country> countryList = new ArrayList<>();
        countryrepos.findAll().iterator().forEachRemaining(countryList::add);
        System.out.println(countryList);

        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }
}
