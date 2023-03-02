package com.example.Brigade.service;

import com.example.Brigade.dto.ResponseDto;
import com.example.Brigade.entities.UserApp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserAppService {

    List<UserApp> getAllUsers();

    ResponseDto getUserById(Integer id) throws ResourceNotFoundException;

    UserApp createUser(UserApp userApp);


    UserApp updateUser(Integer id, UserApp userApp) throws ResourceNotFoundException;

    void deleteUser(Integer id) throws ResourceNotFoundException;
}
