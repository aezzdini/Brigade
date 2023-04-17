package com.example.Brigade.controller;

import com.example.Brigade.dto.ResponseDto;
import com.example.Brigade.entities.UserApp;
import com.example.Brigade.service.ResourceNotFoundException;
import com.example.Brigade.service.UserAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/test")
public class UserAppController {

   private UserAppService userAppService;

    public UserAppController(UserAppService userAppService) {
        this.userAppService = userAppService;
    }


    @GetMapping("/anonymous")
    public ResponseEntity<String> getAnonymous() {
        return ResponseEntity.ok("hello AllUsers");
    }
    @GetMapping("/admin/{id}")
    public ResponseEntity<String> getAdmin(Principal principal, @PathVariable Integer id) {
        JwtAuthenticationToken token =(JwtAuthenticationToken) principal;
        String firstname = (String) token.getTokenAttributes().get("firstname");
        String lastname = (String) token.getTokenAttributes().get("lastname");
        String Email = (String) token.getTokenAttributes().get("email");
        return ResponseEntity.ok("hello Admin\nUser name :" + lastname + "\nUser email : " + Email + "\nUser firstname : " + firstname);
    }
    @GetMapping("/user")
    public ResponseEntity<String> getUser(Principal principal,@PathVariable Integer id) {
        JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
        String firstname = (String) token.getTokenAttributes().get("firstname");
        String lastname = (String) token.getTokenAttributes().get("lastname");
        String Email = (String) token.getTokenAttributes().get("email");
        return ResponseEntity.ok("hello Admin\nUser name :" + lastname + "\nUser email : " + Email + "\nUser firstname : " + firstname);
    }

    @PostMapping("")
    public UserApp createUser(@RequestBody UserApp user) {
        return userAppService.createUser(user);
    }
    @PutMapping("")
    public UserApp updateUser(@PathVariable Integer id, @RequestBody UserApp userApp) throws ResourceNotFoundException {
        return userAppService.updateUser(id, userApp);
    }
    @DeleteMapping("")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) throws ResourceNotFoundException {
        userAppService.deleteUser(id);
        return ResponseEntity.ok().build();}
}
