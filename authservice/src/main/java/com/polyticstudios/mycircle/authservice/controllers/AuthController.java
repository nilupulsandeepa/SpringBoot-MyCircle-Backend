package com.polyticstudios.mycircle.authservice.controllers;

import com.polyticstudios.mycircle.authservice.dtos.LoginUserDto;
import com.polyticstudios.mycircle.authservice.dtos.TestDto;
import com.polyticstudios.mycircle.authservice.dtos.UserDto;
import com.polyticstudios.mycircle.authservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AuthController {

    private UserService userService;

    //---- User Registration
    @PostMapping("/register")
    public ResponseEntity<TestDto> register(@RequestBody UserDto userDto) {
        userService.registerUser(userDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new TestDto("User Created with Name: " + userDto.getFirstName() + " " + userDto.getLastName() + " | email: " + userDto.getEmail()));
    }

    //---- User Login
    @PostMapping("/login")
    public ResponseEntity<TestDto> login(@RequestBody LoginUserDto userDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new TestDto("Login success with email: " + userDto.getEmail()));
    }
}
