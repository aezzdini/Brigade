package com.example.Brigade.controller;

import com.example.Brigade.dto.ResponseDto;
import com.example.Brigade.entities.UserApp;
import com.example.Brigade.service.ResourceNotFoundException;
import com.example.Brigade.service.UserAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserAppController {

   private UserAppService userAppService;

    public UserAppController(UserAppService userAppService) {
        this.userAppService = userAppService;
    }


    @GetMapping("/api/v1/users")
    public List<UserApp> getAllUsers() {
        return userAppService.getAllUsers();
    }
    @GetMapping("/api/v1/users/{id}")
    public ResponseDto getUserById(@PathVariable Integer id) throws ResourceNotFoundException {
        return userAppService.getUserById(id);
    }
    @PostMapping("/api/v1/users")
    public UserApp createUser(@RequestBody UserApp user) {
        return userAppService.createUser(user);
    }
    @PutMapping("/api/v1/users/{id}")
    public UserApp updateUser(@PathVariable Integer id, @RequestBody UserApp userApp) throws ResourceNotFoundException {
        return userAppService.updateUser(id, userApp);
    }
    @DeleteMapping("/api/v1/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) throws ResourceNotFoundException {
        userAppService.deleteUser(id);
        return ResponseEntity.ok().build();}
}
