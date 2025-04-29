package com.example.Hotel_Booking_System.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Hotel_Booking_System.dto.LoginRequestDto;
import com.example.Hotel_Booking_System.dto.LoginResponseDto;
import com.example.Hotel_Booking_System.dto.UserDto;
import com.example.Hotel_Booking_System.entity.User;
import com.example.Hotel_Booking_System.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        userService.registerUser(userDto);
        return ResponseEntity.ok("User registered successfully");
    }

    

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginRequestDto request) {
        User user = userService.loginUser(request.getEmail(), request.getPassword());
        
        if (user != null) {
            LoginResponseDto response = new LoginResponseDto(
                user.getId(),
                user.getName(),
                user.getRole(),
                "Login successful"
            );
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


    @GetMapping("/getall")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
