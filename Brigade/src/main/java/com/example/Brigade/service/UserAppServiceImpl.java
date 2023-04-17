package com.example.Brigade.service;

import com.example.Brigade.dao.UserAppRepository;
import com.example.Brigade.dto.AddressDto;
import com.example.Brigade.dto.ResponseDto;
import com.example.Brigade.dto.UserAppDto;
import com.example.Brigade.entities.UserApp;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
@ComponentScan
@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserAppServiceImpl implements UserAppService {
    private  APIClient apiClient;
    private UserAppRepository userAppRepository;

    @Autowired
    public UserAppServiceImpl(APIClient apiClient) {
        this.apiClient = apiClient;
    }


    @Override
    public List<UserApp> getAllUsers() {
        return userAppRepository.findAll();
    }

    @Override
    public ResponseDto getUserById(Integer userId) {

        ResponseDto responseDto = new ResponseDto();
        UserApp user = userAppRepository.findById(userId).get();
        UserAppDto userDto = mapToUser(user);
        userDto.setId(user.getId());


        AddressDto addressDto = apiClient.getAddressById(user.getAddressId());
        System.out.println("vhebveiher"+addressDto.getCity());
        responseDto.setUser(userDto);
        responseDto.setAddress(addressDto);

        return responseDto;
    }

    private UserAppDto mapToUser(UserApp user){
        UserAppDto userDto = new UserAppDto();
        userDto.setId(user.getId());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());


        return userDto;
    }

    @Override
    public UserApp createUser(UserApp userApp) {
        return userAppRepository.save(userApp);
    }

    @Override
    public UserApp updateUser(Integer id, UserApp userApp) throws ResourceNotFoundException {
        UserApp existingUser = userAppRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        existingUser.setLastname(userApp.getLastname());
        existingUser.setFirstname(userApp.getFirstname());
        return userAppRepository.save(existingUser);
    }



    @Override
        public void deleteUser(Integer id) throws ResourceNotFoundException {
        UserApp existingUserApp = userAppRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserApp", "id", id));
        userAppRepository.delete(existingUserApp);

    }
}
