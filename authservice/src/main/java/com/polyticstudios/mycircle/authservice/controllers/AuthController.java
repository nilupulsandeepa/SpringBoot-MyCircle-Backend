package com.polyticstudios.mycircle.authservice.controllers;

import com.polyticstudios.mycircle.authservice.dtos.LoginUserDto;
import com.polyticstudios.mycircle.authservice.dtos.TestDto;
import com.polyticstudios.mycircle.authservice.dtos.UserDto;
import com.polyticstudios.mycircle.authservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AuthController {

    private UserService userService;

    //---- Hello
    @CrossOrigin
    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Hello From AuthService ADMIN Role");
    }

    @CrossOrigin
    @GetMapping("/hello2")
    public ResponseEntity<String> sayHello2() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Hello From AuthService USER Role");
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<String> all() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Hello From AuthService ALL");
    }

    //---- User Registration
    @CrossOrigin
    @GetMapping("/register")
    public CsrfToken registerGet(CsrfToken token) {
        return token;
    }

    @CrossOrigin
    @PostMapping("/tokenservice")
    public String tokenServie() {
        return "OK";
    }

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<TestDto> register(@RequestBody UserDto userDto) {
        userService.registerUser(userDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new TestDto("User Created with Name: " + userDto.getFirstName() + " " + userDto.getLastName() + " | email: " + userDto.getEmail()));
    }

    //---- User Login
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<TestDto> login(@RequestBody LoginUserDto userDto) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new TestDto("Login success with email: " + userDto.getEmail()));
    }
}
