package com.example.Brigade.service;


import com.example.Brigade.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ADDRESS-SERVER", url = "http://localhost:8081")
public interface APIClient {

    @GetMapping(value = "/api/addresses/{id}")
    AddressDto getAddressById(@PathVariable ("id") long addressid);


}
