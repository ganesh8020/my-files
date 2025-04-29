package com.example.Job_Portal_System.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Job_Portal_System.dto.ApplicationRequest;
import com.example.Job_Portal_System.dto.LoginRequest;
import com.example.Job_Portal_System.dto.LoginResponse;
import com.example.Job_Portal_System.entity.Application;
import com.example.Job_Portal_System.entity.Job;
import com.example.Job_Portal_System.entity.User;
import com.example.Job_Portal_System.repository.UserRepository;
import com.example.Job_Portal_System.service.PortalService;




@RestController
@RequestMapping("/job")
@CrossOrigin(origins = "*")
public class PortalController {
	
    @Autowired 
    private PortalService service;
    
    @Autowired
    UserRepository userrepo;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.registerUser(user);
    }

    @PostMapping("/jobs")
    public Job postJob(@RequestBody Job job) {
        return service.postJob(job);
    }

    @PostMapping("/apply")
    public String applyJob(@RequestBody ApplicationRequest request) {
        service.applyJob(request.getUserId(), request.getJobId(), request.getResumePath());
        return "Application submitted successfully!";
    }


    @GetMapping("/jobs")
    public List<Job> allJobs() {
        return service.getAllJobs();
    }

    @GetMapping("/users")
    public List<User> allUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/applications")
    public List<Application> allApplications() {
        return service.getAllApplications();
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest request) {
        Optional<User> optionalUser = userrepo.findByEmail(request.getEmail());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(request.getPassword())) {
                LoginResponse response = new LoginResponse(user.getId(), user.getName(), user.getEmail(), user.getRole());
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

}

