package com.example.Brigade.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
@Data
public class ResponseDto {

    private UserAppDto user;
    private AddressDto address;
}
