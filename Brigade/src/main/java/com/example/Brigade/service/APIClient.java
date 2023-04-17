package com.example.Brigade.service;


import com.example.Brigade.dto.AddressDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Component


public interface APIClient {

    @GetMapping(value = "/api/addresses/{id}")
    AddressDto getAddressById(@PathVariable ("id") long addressid);


}
